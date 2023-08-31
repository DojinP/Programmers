// 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
package Level1.Ex_42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[] {1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[] per1 = new int[] {1, 2, 3, 4, 5};
        int[] per2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] per3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[] {0, 0, 0};

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == per1[i%5]) score[0]++;
            if(answers[i] == per2[i%8]) score[1]++;
            if(answers[i] == per3[i%10]) score[2]++;
        }

        // 최대값 구하기
        int max = -1;
        for(int val : score){
            if(max < val) max = val;
        }

        List<Integer> answer_list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(max == score[i]) answer_list.add(i+1);
        }

        int[] answer = new int[answer_list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = answer_list.get(i);
        }

        return answer;
    }
}
