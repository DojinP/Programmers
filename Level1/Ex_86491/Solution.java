// 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
package Level1.Ex_86491;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }

    public static int solution(int[][] sizes) {
        int x = 0, y = 0;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] > sizes[i][1]){ // x > y
                if(x < sizes[i][0]) x = sizes[i][0];
                if(y < sizes[i][1]) y = sizes[i][1];
            }else{
                if(x < sizes[i][1]) x = sizes[i][1];
                if(y < sizes[i][0]) y = sizes[i][0];
            }

        }
        return x * y;
    }
}
