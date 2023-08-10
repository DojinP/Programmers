// 숫자 찾기
package Ex_120904;

/*
 * 문제 설명
 * 정수 num과 k가 매개변수로 주어질 때, 
 * num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(1212342, 3));
    }

    public static int solution(int num, int k) {
        int answer = -1;
        int target_digit = 0;
        int tot_digit = 1;
        while(num / 10 != 0){
            // 현재 자리 수가 k 와 같으면 현재 자릿수 저장
            if((num % 10) == k) {
                target_digit = tot_digit;
            }

            tot_digit++;
            num /= 10;
        }

        if(target_digit != 0) {
            // target_digit 이 뒤에서부터의 자리 수이므로 tot_digit에서 값을 빼고 저장
            // 그대로 저장하면 idx 값이 저장되므로 +1 처리
            answer = tot_digit - target_digit + 1;
        }

        return num == k ? 1 : answer;
    }
}