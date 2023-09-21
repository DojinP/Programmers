// https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
package Level3.Ex_49189;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        //System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); // 3
        //System.out.println(solution(11, new int[][] {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 5}, {3, 6}, {4, 8}, {4, 9}, {5, 9}, {5, 10}, {6, 10}, {6, 11}})); // 4
    }

    public static int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n]; // 방문한 노드 체크
        int[] depths = new int[n]; // 각 노드의 최소 깊이

        // BFS 계산을 위한 queue 객체 생성
        Queue<Integer> queue = new LinkedList<>();

        // 1번 노드(0) 방문처리
        visited[0] = true;
        depths[0] = 1;

        // 1번 노드와 연결된 노드 추가
        for (int i = 0; i < edge.length; i++) {
            if (edge[i][1] == 1) {
                depths[edge[i][0] - 1] = depths[0] + 1;
                visited[edge[i][0]-1] = true;
                queue.add(edge[i][0]);
            } else if (edge[i][0] == 1) {
                depths[edge[i][1] - 1] = depths[0] + 1;
                visited[edge[i][1]-1] = true;
                queue.add(edge[i][1]);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < edge.length; i++) {
                if (edge[i][1] == now && !visited[edge[i][0]-1]) {
                    depths[edge[i][0] - 1] = depths[edge[i][1] - 1] + 1;
                    visited[edge[i][0]-1] = true;
                    queue.add(edge[i][0]);
                } else if (edge[i][0] == now && !visited[edge[i][1]-1]) {
                    depths[edge[i][1] - 1] = depths[edge[i][0] - 1] + 1;
                    visited[edge[i][1]-1] = true;
                    queue.add(edge[i][1]);
                }
            }

        }

        int max = 0;
        for (int i = 0; i < depths.length; i++) {
            if (max < depths[i]) max = depths[i];
        }

        int count = 0;
        for (int i = 0; i < depths.length; i++) {
            if (depths[i] == max) count++;
        }

        System.out.println(Arrays.toString(depths));

        return count;

    }
}

