// H-index
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
package Level2.Ex_42747;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
        System.out.println(solution(new int[] {3, 1, 10, 2, 7, 9, 30}));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            if(citations[i] >= h) return h;
        }

        return answer;
    }
}
