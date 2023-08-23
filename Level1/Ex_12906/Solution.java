// 같은 숫자는 싫어
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
package Level1.Ex_12906;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int [] {1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int [] {4, 4, 4, 3, 3})));
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            }else{
                if(stack.lastElement() != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }

        int[] answer = new int[stack.size()];
        for(int i= answer.length-1; i>=0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}