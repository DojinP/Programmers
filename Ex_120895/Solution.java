// 인덱스 바꾸기

package Ex_120895;

/*
 * 문제 설명
 * 
 * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, 
 * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
 * 
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("hello", 1, 2));
    }

    public static String solution(String my_string, int num1, int num2) {

        char[] charArr = my_string.toCharArray();

        char temp = charArr[num1];
        charArr[num1] = charArr[num2];
        charArr[num2] = temp;

        return String.valueOf(charArr);
    }
}