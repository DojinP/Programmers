package Ex_120838;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(".... . .-.. .-.. ---"));
        System.out.println(solution(".--. -.-- - .... --- -."));
    }

    public static String solution(String letter) {
        String answer = "";
        String[] morse_in_letter = letter.split(" ");
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        for(int i=0; i<morse_in_letter.length; i++){
            int target_idx = (getMorseIdx(morse, morse_in_letter[i]));
            if(target_idx == -1) {
                return "error";
            }else{
                answer += (char)(target_idx+97);
            }
        }

        return answer;
    }

    public static int getMorseIdx(String[] morse, String target){
        for(int i=0; i<morse.length; i++){
            if(target.equals(morse[i])) return i;
        }
        return -1;
    }
}