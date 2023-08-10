package Ex_120835;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] result = solution(new int[] {30, 10, 23, 6, 100});

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] emergency) {
        // 응급도 배열
        int[] emPoint = new int[101];
        // 응급도 순서 배열
        int[] answer = new int[emergency.length];


        // 원소 0으로 초기화
        Arrays.setAll(emPoint, i -> 0);
        
        for(int i=0; i<emergency.length; i++){
            // 환자 존재하는 경우 해당 응급도 배열에 순서 저장
            emPoint[emergency[i]]++;
        }

        // 응급도 배열에 저장된 값(1)을 순서값으로 만들기
        int orderPoint = 0;
        for(int i=emPoint.length-1; i>=0; i--){
            if(emPoint[i] != 0) {
                emPoint[i] += orderPoint;
                orderPoint++;
            }
        }

        // 응급도 순서 배열 초기화
        for(int i=0; i<emergency.length; i++){
            answer[i] = emPoint[emergency[i]];
        }

        return answer;
    }
}