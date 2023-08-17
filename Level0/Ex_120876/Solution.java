// 겹치는 선분의 길이
package Ex_120876;

/*
 * 선분 3개가 평행하게 놓여 있습니다. 
 * 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
 * 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
 */

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 1}, {2, 5}, {3, 9}}));
        System.out.println(solution(new int[][] {{-1, 1}, {1, 3}, {3, 9}}));
        System.out.println(solution(new int[][] {{0, 5}, {3, 9}, {1, 10}}));
    }

    public static int solution(int[][] lines) {
        int[] dupPoint = new int[200];
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]; j<lines[i][1]; j++){
                dupPoint[j+100]++;
            }
        }

        // System.out.println(Arrays.toString(dupPoint));

        return (int)Arrays.stream(dupPoint).filter(i -> i >= 2).count();
    }
}