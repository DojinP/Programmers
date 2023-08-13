package Ex_120885;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("1011", "1011011"));
    }

    public static String solution(String bin1, String bin2) {
        String answer = Integer.toBinaryString(Integer.parseInt(bin1, 2)+Integer.parseInt(bin2, 2));
        
        return answer;
    }
}