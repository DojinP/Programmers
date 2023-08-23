// 기능 개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
package Level1.Ex_42586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
//        System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {96, 94}, new int[] {3, 3}))); // 11번 반례
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> release_dates = new ArrayList<Integer>();

        for(int i = 0; i<progresses.length; i++){
            progresses[i] = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
        }

        int count = 0;
        for(int i = 0; i<progresses.length; i += count){
            // 마지막 요소 비교 시 탈출문
            if(progresses[i] <= 0) break;

            count = 0;
            int days = progresses[i];
            for(int j = 0; j<progresses.length; j++) progresses[j] -= days;
            for(int j = i; j<progresses.length; j++){
                if(progresses[j] <= 0) {
                    count++;
                }
                else {
                    break;
                }
            }

            release_dates.add(count);
        }

        return release_dates.stream().mapToInt(i -> i).toArray();
    }
}