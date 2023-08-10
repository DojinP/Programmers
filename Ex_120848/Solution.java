// 팩토리얼
package Ex_120848;

/*
 * 문제 설명
 * i 팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다. 
 * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 
 * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.\
 * i! ≤ n
 */

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(120));
    }

    public static int solution(int n) {
        if(n == 1) return n;
        for(int i=2; i<=10; i++){
            if(n/i==1) return i;
            if(n/i==0) return i-1;
            n/=i;
        }
        
        return 0;
    }
}