// 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
package Level2.Ex_86971;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
//        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
//        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public static int solution(int n, int[][] wires) {
        int max = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<wires.length; i++) {
            Arrays.fill(visited, false);
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            Stack<Integer> node1_stack = new Stack<>();
            Stack<Integer> node2_stack = new Stack<>();

            for(int j=0; j<wires.length; j++) {
                if(i==j) continue;

                if(node1 == wires[j][0]){

                }

                if(node2 == wires[j][0]){

                }

            }

        }

        return 0;
    }
}
