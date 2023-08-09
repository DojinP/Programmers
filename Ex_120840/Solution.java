// 구슬을 나누는 경우의 수
package Ex_120840;

/*
 * 문제 설명
 * 
 * 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다. 
 * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
 * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
 * 
 */

/*
 * 제한사항
 * 1 ≤ balls ≤ 30
 * 1 ≤ share ≤ 30
 * 구슬을 고르는 순서는 고려하지 않습니다.
 * share ≤ balls
 */

/*
 * 입출력 예
 * balls	share	result
 * 3	    2	    3
 * 5	    3	    10
 */

/// int 자료형의 오버플로우를 주의해서 풀어야하는 문제
/// long 자료형으로 리턴 타입을 변경하거나 java.util.BigInteger를 사용하여 풀이한 경우가 대다수
/// int 자료형으로 풀 수 있는 방법이 존재한다고 하는데.. 잘 모르겠다.

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(30, 15));
    }

    public static long solution(int balls, int share) {
        long answer = 1;

        for(int i=0; i<share; i++){
            answer *= balls-i;
            answer /= i+1;
        }

        return answer;
    }
}