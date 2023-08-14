// 삼각형의 완성조건 (2)
package Ex_120868;

/*
 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
 * 
 * > 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 * 
 * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {11, 7}));
    }

    public static int solution(int[] sides) {
        int answer = 0;
        int num1, num2;
        
        if(sides[0] > sides[1]){
            num1 = sides[0];
            num2 = sides[1];
        }else{
            num1 = sides[1];
            num2 = sides[0];
        }

        // 주어진 두 변의 합
        int sum = num1 + num2;

        // 나머지 한 변이 제일 긴 경우
        for(int i=num1; i<sum; i++){
            answer++;
        }

        // 주어진 수 중 큰 수가 제일 긴 변인 경우
        for(int i=1; i<num1; i++){
            if(num2+i > num1) answer++;
        }

        return answer;
    }
}