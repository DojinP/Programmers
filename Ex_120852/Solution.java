// 소인수분해
package Ex_120852;

import java.util.*;

/*
 * 문제 설명
 * 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 
 * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다. 
 * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12)));
    }

    public static int[] solution(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        
        for(int i=2; i<=n; i++){
            if(n%i == 0){
                if(!factors.contains(i)){
                    factors.add(i);
                }
                n /= i;
                i--; // 재시행
            }
        }
        
        return factors.stream().mapToInt(i->i).toArray();
    }
}