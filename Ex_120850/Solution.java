// 문자열 정렬하기(1)
package Ex_120850;

/*
 * 문제 설명
 * 문자열 my_string이 매개변수로 주어질 때, my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
 * 
 * 제한사항
 * 1 ≤ my_string의 길이 ≤ 100
 * my_string에는 숫자가 한 개 이상 포함되어 있습니다.
 * my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -
 * 
 */

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("hi12392")));
        System.out.println(Arrays.toString(solution("p2o4i8gj2")));
    }

    public static int[] solution(String my_string) {
        List<Integer> numlist_in_str = new ArrayList<Integer>(); 

        for(int i=0; i<my_string.length(); i++){
            char char_in_str = my_string.charAt(i);
            if('0' <= char_in_str && char_in_str <= '9'){
                numlist_in_str.add(Integer.valueOf(char_in_str-'0'));
            }
        }

        int[] answer = numlist_in_str.stream().mapToInt(i -> i).sorted().toArray();
        
        return answer;
    }
}