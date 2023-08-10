// 대문자와 소문자

package Ex_120893;

/*
 * 문제 설명
 * 문자열 my_string이 매개변수로 주어질 때, 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("cccCCC"));
    }

    public static String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            char target = my_string.charAt(i);
            if(target >= 'a') answer += (char)(target - 32);
            else answer += (char)(target + 32);
        }
        return answer;
    }
}