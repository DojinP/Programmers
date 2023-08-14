// 7의 개수
package Ex_120912;

/*
 * 문제 설명
 * 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 77, 17}));
        System.out.println(solution(new int[] {10, 29}));
        System.out.println(solution(new int[] {127, 2}));
    }

    public static int solution(int[] array) {
        String str = "";

        // 모든 원소 문자열로 합
        for(int i=0; i<array.length; i++){
            str += String.valueOf(array[i]);
        }

        // 마지막 자리에 7이 오는 경우 나누어지지 않으므로 7이 아닌 숫자를 끝에 추가
        str += "0";

        // 7을 기준으로 분리
        String[] sevenSplitStr = str.split("7");

        // 7이 없는 경우 배열크기 1, 7의 개수 = 배열의 전체 크기 -1
        return sevenSplitStr.length - 1;
    }
}