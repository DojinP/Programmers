// A로 B 만들기
package Ex_120886;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * 문제 설명
 * 문자열 before와 after가 매개변수로 주어질 때, before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("olleh", "hello"));
        System.out.println(solution("allpe", "apple"));
    }

    public static int solution(String before, String after) {
        return Arrays.stream(before.split("")).sorted().collect(Collectors.joining()).equals(Arrays.stream(after.split("")).sorted().collect(Collectors.joining())) ? 1 : 0;
    }
}