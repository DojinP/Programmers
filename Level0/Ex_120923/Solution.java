// 연속된 수의 합
package Ex_120923;

import java.util.Arrays;

/*
 * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 
 * 두 정수 num과 total이 주어집니다. 
 * 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, 0)));
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(6, 27)));
    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(total == 0){
            for(int i=0; i<num; i++) answer[i] = -num / 2 + i;
        }else if(total % num == 0){
            for(int i=0; i<num; i++) answer[i] = (total/num)-(num/2)+i;
        }else{
            for(int i=0; i<num; i++) answer[i] = (total/num)-(num/2-1)+i;
        }

        return answer;
    }
}