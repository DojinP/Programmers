// 최댓값 만들기 (2)

package Ex_120862;

import java.util.*;
// import java.util.stream.*;

/*
 * 
 * 문제 설명
 * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
 * 
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, -3, 4, -5}));
        System.out.println(solution(new int[] {0, -31, 24, 10, 1, 9}));
        System.out.println(solution(new int[] {10, 20, 30, 5, 5, 20, 5}));
    }

    public static int solution(int[] numbers) {        
        // List<Integer> numbers_list = Arrays.stream(numbers)
        //                                     .boxed()
        //                                     .sorted()
        //                                     .collect(Collectors.toList());

        numbers = Arrays.stream(numbers).sorted().toArray();

        int neg = numbers[0] * numbers[1];
        int pos = numbers[numbers.length-1] * numbers[numbers.length-2];
        return neg > pos ? neg : pos;
    }
}