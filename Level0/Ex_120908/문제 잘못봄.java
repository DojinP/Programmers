// // 갯수 구하는 문제인줄...

// package Ex_120908;

// class Solution {

//     public static void main(String[] args) {
//         System.out.println(solution("ppprrrogrammers", "pppp"));
//     }

//     public static int solution(String str1, String str2) {
//         int count = 0;
//         boolean check = false;
//         for(int i=0; i<str1.length(); i++){
//             if(str1.charAt(i) == str2.charAt(0)){
//                 // 현재 str1 문자의 위치 + str2 의 길이가 str1의 총 길이보다 길면 종료
//                 if((i+1)+str2.length() > str1.length()) break;

//                 // str1 시작 위치부터 str2 길이만큼 비교
//                 for(int j=1; j<str2.length(); j++){
//                     if(str1.charAt(i+j) != str2.charAt(j)) {
//                         check = false;
//                         break;
//                     }
//                     else check = true;
//                 }

//                 // 모두 일치하면 카운트 증가, str2 길이만큼 i 증가
//                 if(check) {
//                     count++;
//                     i += str2.length()-1;   // for문에서 자연히 증가하는 +1 제외
//                 }
//             }
//         }

//         return count;
//     }
// }