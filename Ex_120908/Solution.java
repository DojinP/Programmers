package Ex_120908;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("A", "A"));
    }

    public static int solution(String str1, String str2) {
        boolean check = false;
        for(int i=0; i<str1.length(); i++){
            // 첫 글자 매치 시
            if(str1.charAt(i) == str2.charAt(0)){
                // 현재 str1 문자의 위치 + str2 의 길이가 str1의 총 길이보다 길면 종료
                if(i+str2.length() > str1.length()) break;

                // 매치된 문자의 다음 문자부터 비교 (이 경우 문자 길이 1일때 문제된다.)
                // for(int j=1; j<str2.length(); j++){
                //     if(str1.charAt(i+j) != str2.charAt(j)) {
                //         check = false;
                //         break;
                //     }
                //     else check = true;
                // }

                // 문자 처음부터 다시 비교
                for(int j=0; j<str2.length(); j++){
                    if(str1.charAt(i+j) != str2.charAt(j)) {
                        check = false;
                        break;
                    }
                    else check = true;
                }

                // 모두 일치하면 카운트 증가, str2 길이만큼 i 증가
                if(check) {
                    return 1;
                }
            }
        }

        return 2;
    }
}