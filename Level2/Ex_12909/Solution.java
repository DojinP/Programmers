// 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
package Level2.Ex_12909;

import java.util.Stack;

class Solution {

   public static void main(String[] args) {
        System.out.println(solution("(())"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
   }

   public static boolean solution(String s) {

        Stack<Character> brackets = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                brackets.push(s.charAt(i));
            } 
            if(s.charAt(i) == ')') {
                if(brackets.isEmpty()) return false;
                brackets.pop();
            }
        }

        return brackets.isEmpty() ? true : false;
    }
}