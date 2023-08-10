package Ex_120822;

public class Solution {

    public static void main(String[] args) {
        String tc1 = solution("jaron");
        String tc2 = solution("bread");

        System.out.println(tc1);
        System.out.println(tc2);
    }

    public static String solution(String my_string) {
        String answer = "";
        
        for(int i=my_string.length()-1; i>=0; i--){
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}
