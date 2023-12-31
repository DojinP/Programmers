// 문자열 밀기
package Ex_120921;

/*
 * 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다. 
 * 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때, 
 * A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("hello", "ohell"));
        System.out.println(solution("apple"	, "elppa"));
        System.out.println(solution("atat", "tata"));
        System.out.println(solution("abc", "abc"));
    }

    public static int solution(String A, String B) {
        if(A.equals(B)) return 0;

        for(int i=0; i<B.length(); i++){
            A = A.charAt(A.length()-1) + A.substring(0, A.length()-1);
            if(A.equals(B)) return i+1;
        }
        return -1;
    }
}