// 중복된 문자 제거
package Ex_120888;

import java.util.*;
// import java.util.stream.*;

/*
 * 문제 설명
 * 문자열 my_string이 매개변수로 주어집니다. my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
 * 
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("people"));
        System.out.println(solution("We are the world"));
    }

    public static String solution(String my_string) {
        // distinct() 활용
        // return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());

        // HashSet 활용
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();

        for(char c : my_string.toCharArray()){
            if(hs.add(c)){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}