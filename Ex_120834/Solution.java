package Ex_120834;

class Solution {

    public static void main(String[] args) {
        String result = solution(1000);

        System.out.println(result);
    }

    public static String solution(int age) {
        String target = "";
        String answer = "";
        String[] alpAgeBase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        // 아랫 자리수 부터 변환
        while(age != 0){
            target += alpAgeBase[age % 10];
            age /= 10;
        }

        // 배열 reverse
        for(int i=target.length()-1; i>=0; i--){
            answer += target.charAt(i);
        }

        return answer;
    }
}