// 가장 큰 수 찾기
package Ex_120899;

import java.util.Arrays;

/*
 * 문제 설명
 * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 */
 
class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 8, 3})));
        System.out.println(Arrays.toString(solution(new int[] {9, 10, 11, 8})));
    }

    public static int[] solution(int[] array) {
        int max = 0, max_idx = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
                max_idx = i;
            }
        }
        int[] answer = {max, max_idx};
        return answer;
    }
}