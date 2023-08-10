// 문자열 정렬하기 (2)
package Ex_120911;

import java.util.stream.*;

/*
 * 문제 설명
 * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때, 
 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("Bcad"));
        System.out.println(solution("heLLo"));
        System.out.println(solution("Python"));
    }

    public static String solution(String my_string) {
        return Stream.of(my_string.toLowerCase().split(""))
                            .sorted()
                            .collect(Collectors.joining());
    }

    // 희표님 솔루션 참고 (collections/stream 활용)
    // public String solution(String myString) {
    //     return Arrays.stream(myString.toLowerCase(Locale.ROOT).split("")).sorted().collect(Collectors.joining());
    // }
}