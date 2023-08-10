// n의 배수 고르기

package Ex_120905;

import java.util.ArrayList;
import java.util.Arrays;
    import java.util.List;

/*
 * 문제 설명
 * 
 * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
 * 
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {2, 100, 120, 600, 12, 12})));
    }

    public static int[] solution(int n, int[] numlist) {
        List<Integer> ansList = new ArrayList<>();

        for(int i=0; i<numlist.length; i++){
            if(numlist[i] % n == 0) ansList.add(numlist[i]);
        }

        int[] answer = ansList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}