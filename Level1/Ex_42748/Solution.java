// k번째 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
package Level1.Ex_42748;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int tc=0; tc<commands.length; tc++) {
            // i, j, k 값
            int i = commands[tc][0], j = commands[tc][1], k = commands[tc][2];

            // 정렬할 임시 배열 할당
            int[] tempArr = new int[j-i+1]; int idx = 0;

            // 정렬할 임시 배열 초기화
            for(int n=i-1; n<=j-1; n++) {
                tempArr[idx++] = array[n];
            }
//            System.out.println("임시 배열 : " + Arrays.toString(tempArr));

            // 임시 배열 정렬
            for(int n=0; n<tempArr.length-1; n++) {
                for(int m=n; m<tempArr.length; m++) {
                    if(tempArr[m] < tempArr[n]){
                        int temp = tempArr[m];
                        tempArr[m] = tempArr[n];
                        tempArr[n] = temp;
                    }
                }
            }
//            System.out.println("정렬한 임시 배열 : " + Arrays.toString(tempArr));

            // 정렬된 임시 배열의 k 번째 요소 저장
            answer[tc] = tempArr[k-1];
        }
        return answer;
    }
}
