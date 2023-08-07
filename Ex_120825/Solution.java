package Ex_120825;

public class Solution {

    public static void main(String[] args) {
        String result = solution("hello", 3);

        System.out.println(result);
    }

    public static String solution(String my_string, int n) {
        String answer = "";

        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<n; j++){
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }
}
