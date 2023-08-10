// 약수 구하기
package Ex_120897;

import java.util.*;

/*
 * 문제 설명
 * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(29)));
    }

    public static int[] solution(int n) {
        List<Integer> divisor_list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n % i == 0) divisor_list.add(i);
        }
        int[] answer = divisor_list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}