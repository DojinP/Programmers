package Ex_120907;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"3 - 4 = -3", "5 + 6 = 11"})));
        System.out.println(Arrays.toString(solution(new String[] {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
    }

    public static String[] solution(String[] quiz) {

        String[] answer = new String[quiz.length];

        for(int i=0; i<quiz.length; i++){
            int idx = 0;
            int operand1 = 0, operand2 = 0, result = 0;
            char oper = 0;
            for(int j=0; j<quiz[i].length(); j++){
                if(quiz[i].charAt(j) == '-' && quiz[i].charAt(j+1) == ' ' || quiz[i].charAt(j) == '+'){
                    operand1 = Integer.parseInt(quiz[i].substring(idx, j-1));
                    oper = quiz[i].charAt(j);
                    idx = j+2;
                    continue;
                }

                if(quiz[i].charAt(j) == '='){
                    operand2 = Integer.parseInt(quiz[i].substring(idx, j-1));
                    result = Integer.parseInt(quiz[i].substring(j+2, quiz[i].length()));
                    break;
                }
            }

            if(oper == '+'){
                answer[i] = result == operand1 + operand2 ? "O" : "X";
            }else{
                answer[i] = result == operand1 - operand2 ? "O" : "X";
            }
        }
        
        return answer;
    }
}
