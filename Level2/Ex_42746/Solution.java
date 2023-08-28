// 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
package Level2.Ex_42746;

// 정렬.. 직접 구현은 아직 어렵다..

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(solution(new int[] {6, 10, 2}));
//        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
//        System.out.println(solution(new int[] {12, 21}));
//        System.out.println(solution(new int[] {1, 0, 0, 0}));
        System.out.println(solution(new int[] {0, 0, 0, 0}));
        System.out.println(solution(new int[] {34, 3444, 32, 3222}));
    }

    public static String solution(int[] numbers) {
//        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//
//        System.out.println("기존 문자열 배열 : " + Arrays.toString(strArr));
//
//        for(int i=0; i<strArr.length-1; i++) {
//            for(int j=i+1; j<strArr.length; j++){
//                int len_a = strArr[i].length();
//                int len_b = strArr[j].length();
////                int count = 0;
////                while(count < len_a && count < len_b){
////                    // 큰 수로 시작하는 값을 앞으로
////                    char a = strArr[i].charAt(count);
////                    char b = strArr[j].charAt(count);
////
////                    if(a < b){ // b가 더 큰 경우
////                        String temp = strArr[j];
////                        strArr[j] = strArr[i];
////                        strArr[i] = temp;
////                        break;
////                    }else if(a == b){ // 앞자리가 동일한 경우
//                        count++;
//                    }else{  // a가 더 큰 경우
//                        count = 0;
//                        break;
//                    }
//                }
//
//                // count 범위를 벗어나 while 문을 탈출한 경우 (i 혹은 j 요소가 사이즈를 벗어남)
//                if(count != 0){
//                    if(len_a > len_b){  // i 요소가 더 긴 경우
//                        if(strArr[i].charAt(count) < strArr[i].charAt(count-1)){
//                            String temp = strArr[j];
//                            strArr[j] = strArr[i];
//                            strArr[i] = temp;
//                        }
//                    }else if (len_b > len_a){  // j 요소가 더 긴 경우
//                        if(strArr[j].charAt(count) >= strArr[j].charAt(count-1)){
//                            String temp = strArr[j];
//                            strArr[j] = strArr[i];
//                            strArr[i] = temp;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("정렬 된 문자열 배열 : " + Arrays.toString(strArr));

//      return strArr[0].equals("0") ? "0" : Arrays.stream(strArr).collect(Collectors.joining());
//      return String.valueOf(Long.parseLong(Arrays.stream(strArr).collect(Collectors.joining())));
        String answer = Arrays.stream(numbers).mapToObj(String::valueOf).sorted(((o1, o2) -> (o2 + o1).compareTo(o1 + o2))).collect(Collectors.joining());
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
