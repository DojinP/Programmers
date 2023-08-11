// 숨어있는 숫자의 덧셈 (2)
package Ex_120864;

/*
 * 문제 설명
 * 문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("1a2b3c4d123Z"));
    }

    public static int solution(String my_string) {
        int answer = 0;
        String nnStr = "0";

        for(int i=0; i<my_string.length(); i++){
            char target = my_string.charAt(i);
            if(target >= '0' && target <= '9') nnStr += target;
            else{
                answer += Integer.parseInt(nnStr);
                nnStr = "0";
            }
        }

        return answer += Integer.parseInt(nnStr);
    }
}