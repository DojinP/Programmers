// https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
package Level3.Ex_49189;

import java.util.Arrays;
import java.util.Stack;

public class 가장_먼_노드 {
    public static void main(String[] args) {
//        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); // 3
        System.out.println(solution(11, new int[][] {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 5}, {3, 6}, {4, 8}, {4, 9}, {5, 9}, {5, 10}, {6, 10}, {6, 11}})); // 4
    }

    public static int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n]; // 방문한 노드 체크
        int[] depths = new int[n]; // 각 노드의 최소 깊이
        Stack<Integer> stack = new Stack<>();

        visited[0] = true; // 1번 노드부터 시작하므로 방문 처리
        depths[0] = 1; // 1번 노드의 깊이를 1로 설정

        for(int i=0; i<edge.length; i++){
            // 1번 노드와 연결된 Node를 Stack에 추가
            if(edge[i][0] == 1){
                stack.push(edge[i][1]);
                // 방문처리, depth 계산
                visited[edge[i][1]-1] = true;
                depths[edge[i][1]-1] = depths[0]+1;
            }else if(edge[i][1] == 1){
                stack.push(edge[i][0]);
                // 방문처리, depth 계산
                visited[edge[i][0]-1] = true;
                depths[edge[i][0]-1] = depths[0]+1;
            }
        }

        while(!stack.isEmpty()){
            int now = stack.pop();
            System.out.println(now + " 방문");

            for(int i=0; i<edge.length; i++){
                if(edge[i][0] == now){
                    if(!visited[edge[i][1]-1]){
                        stack.push(edge[i][1]);
                        visited[edge[i][1]-1] = true;
                        depths[edge[i][1]-1] = depths[now-1] + 1;
                    }else if(depths[edge[i][1]-1] > depths[now-1] + 1){
                        stack.push(edge[i][1]);
                        depths[edge[i][1]-1] = depths[now-1] + 1;
                    }
                }else if(edge[i][1] == now){
                    if(!visited[edge[i][0]-1]){
                        stack.push(edge[i][0]);
                        visited[edge[i][0]-1] = true;
                        depths[edge[i][0]-1] = depths[now-1] + 1;
                    }else if(depths[edge[i][0]-1] > depths[now-1] + 1){
                        stack.push(edge[i][0]);
                        depths[edge[i][0]-1] = depths[now-1] + 1;
                    }
                }
            }

        }

        int max = 0;
        for(int i=0; i<depths.length; i++){
            if(depths[i] > max) max = depths[i];
        }

        int count = 0;
        for(int i=0; i<depths.length; i++){
            if(depths[i] == max) count++;
        }

        //System.out.println(Arrays.toString(depths));

        return count;
    }
}
