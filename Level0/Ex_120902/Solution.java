// 문자열 계산하기
package Ex_120902;

/*
 * my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("3 + 4"));
        System.out.println(solution("3 + 4 - 2 + 10 + 29 - 12"));
    }

    public static int solution(String my_string) {
        String[] operArr = my_string.split(" ");

        boolean answerIsSet = false;
        int answer = 0;

        for(int i=0; i<operArr.length; i++){
            if(operArr[i].equals("+")){
                answer += Integer.parseInt(operArr[i+1]);
                i++;
            }else if(operArr[i].equals("-")){
                answer -= Integer.parseInt(operArr[i+1]);
                i++;
            }else{
                if(!answerIsSet){
                    answer = Integer.parseInt(operArr[i]);
                    answerIsSet = true;
                }
            }
        }
        
        return answer;
    }
}