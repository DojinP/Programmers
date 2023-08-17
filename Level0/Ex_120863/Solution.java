// 다항식 더하기
package Ex_120863;

/*
 * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
 * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 
 * 같은 식이라면 가장 짧은 수식을 return 합니다.
 */

class Solution {

    public static void main(String[] args) {
        // System.out.println(solution("3x + 7 + x")); // "4x + 7"
        // System.out.println(solution("x + x + x"));  // "3x"
        System.out.println(solution("x + 1"));
    }

    public static String solution(String polynomial) {
        String[] splitStr = polynomial.split("\\+");
        int coe = 0;
        int con = 0;
        
        for(int i=0; i<splitStr.length; i++){
            int len = splitStr[i].trim().length();
            if(splitStr[i].trim().charAt(len-1) == 'x'){
                if(splitStr[i].trim().equals("x")) coe++;
                else coe += Integer.parseInt(splitStr[i].trim().substring(0, len-1));
            }else{
                con += Integer.parseInt(splitStr[i].trim());
            }
        }

        String xstr = coe == 1 ? "x" : coe + "x";
        
        if(coe != 0 && con != 0) return xstr + " + " + con;
        else if(coe != 0) return xstr;
        else return "" + con;
    }
}