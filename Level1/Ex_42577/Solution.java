// 전화번호 목록
// https://school.programmers.co.kr/learn/courses/30/lessons/42577
package Level1.Ex_42577;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[] {"123","456","789"}));
        System.out.println(solution(new String[] {"12","123","1235","567","88"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        String[] clone_pb = phone_book.clone();

        for(String str : phone_book){
            for(int i=0; i<clone_pb.length; i++){
                if(str.equals(clone_pb[i])) continue;
                boolean isPrefix = false;
                for(int j=0; j<str.length(); j++){
                    if(str.charAt(j) != clone_pb[i].charAt(j)) {
                        isPrefix = false;
                        break;
                    }
                    else {
                        isPrefix = true;
                        continue;
                    }
                }
                if(isPrefix) return false;
            }
        }

        return answer;
    }
}
