// 한 번만 등장한 문자
package Ex_120896;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * 문제 설명
 * 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 
 * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
        System.out.println(solution("abdc"));
        System.out.println(solution("hello"));
    }

    public static String solution(String s) {
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] > 1) s = s.replaceAll(String.valueOf((char)(i+'a')), "");
        }

        return Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
    }
}