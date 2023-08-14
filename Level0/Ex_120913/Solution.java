// 잘라서 배열로 저장하기
package Ex_120913;

/*
 * 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
 */

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abc1Addfggg4556b", 6)));
    }

    public static String[] solution(String my_str, int n) {
        List<String> strList = new ArrayList<>();

        while(my_str.length() > n){
            strList.add(my_str.substring(0, n));
            my_str = my_str.substring(n);
        }
        // n 보다 작은 문자열 저장
        strList.add(my_str);

        return strList.toArray(new String[0]);
    }
}