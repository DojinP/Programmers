package Ex_120826;

class Solution {

    public static void main(String[] args) {
        String result1 = solution("abcdef", "f");
        String result2 = solution("BCBdbe", "B");

        System.out.println(result1);
        System.out.println(result2);
    }

    public static String solution(String my_string, String letter) {
        String answer = my_string.replaceAll(letter, "");
        return answer;
    }
}