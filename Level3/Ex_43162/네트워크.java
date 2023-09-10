// https://school.programmers.co.kr/learn/courses/30/lessons/43162
package Level3.Ex_43162;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            // 방문한 노드가 아닐 경우 (다른 네트워크 상의 노드인 경우)
            if(!visited[i]){
                bfs(i, computers, visited); // 인접 노드를 모두 방문하는 BFS
                count++;    // 네트워크 개수
            }
        }
        return count;
    }

    public static void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        // 현재 노드 방문
        visited[start] = true;
        // 현재 노드 큐에 추가
        queue.add(start);

        // 큐에서 값을 꺼내 인접 노드를 방문하는 로직
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<computers.length; i++) {
                if(i == now) continue;
                if(computers[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
