// 모음사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
package Level2.Ex_84512;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution1("AE"));
    }

    // 수학적 풀이
    public static int solution1(String word) {
        // 공식
        // 1의 자리수 변경시 (5^4 + 5^3 + 5^2 + 5^1 + 5^0) * level (A = 0, E = 1, ...)
        // 2의 자리수 변경시 (5^3 + 5^2 + 5^1 + 5^0) * level
        // ...

        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] lineVal = new int[5];
        for(int i=0; i<5; i++){
            for(int j=4-i; j>=0; j--){
                lineVal[i] += (int)Math.pow(5, j);
            }
        }

        System.out.println(Arrays.toString(lineVal));

        int order = 0;
        for(int i=0; i<word.length(); i++){
            char target = word.charAt(i);
            int change_val = 0;
            for(int j=0; j<vowels.length; j++){
                if(target == vowels[j]) {
                    change_val = j;
                    break;
                }
            }
            order += lineVal[i] * change_val + 1; // A는 각 자리수마다 1의 값을 갖는다 (Order) ex> A = 1, AA = 2 ..
        }

        return order;
    }

    // DFS 풀이
//    public static int solution2(String word) {
//        int answer = 0;
//        return answer;
//    }
}
