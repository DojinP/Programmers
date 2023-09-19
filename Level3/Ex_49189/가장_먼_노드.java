// https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java
package Level3.Ex_49189;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Stack;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); // 3
    }

    public static int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n]; // 방문한 노드 체크
        int[] depths = new int[n]; // 각 노드의 최소 깊이
        //Stack<Node> stack = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        visited[0] = true; // 1번 노드부터 시작하므로 방문 처리
        depths[0] = 1; // 1번 노드의 깊이를 1로 설정

        for(int i=0; i<edge.length; i++){
            // 1번 노드와 연결된 Node를 Stack에 추가
            if(edge[i][0] == 1){
                System.out.println(edge[i][1] + " 을 push 합니다. depth : " + (depths[0]+1));
                //stack.push(new Node(depths[0]+1, edge[i][1]));
                stack.push(edge[i][1]);
                // 방문처리, depth 계산
                visited[edge[i][1]-1] = true;
                depths[edge[i][1]-1] = depths[0]+1;
            }else if(edge[i][1] == 1){
                System.out.println(edge[i][0] + " 을 push 합니다. depth : " + (depths[0]+1));
                //stack.push(new Node(depths[0]+1, edge[i][0]));
                stack.push(edge[i][0]);
                // 방문처리, depth 계산
                visited[edge[i][0]-1] = true;
                depths[edge[i][0]-1] = depths[0]+1;
            }
        }

        int max = 0;

        while(!stack.isEmpty()){
            int now = stack.pop();
            max = Math.max(max, depths[now-1]);

            for(int i=0; i<edge.length; i++){
                if(edge[i][0] == now){
                    if(!visited[edge[i][1]-1]){
                        stack.push(edge[i][1]);
                        visited[edge[i][1]-1] = true;
                        depths[edge[i][1]-1] = depths[now-1] + 1;
                    }
                }else if(edge[i][1] == now){
                    if(!visited[edge[i][0]-1]){
                        stack.push(edge[i][0]);
                        visited[edge[i][0]-1] = true;
                        depths[edge[i][0]-1] = depths[now-1] + 1;
                    }
                }
            }

            /*Node now = stack.pop();
            System.out.println("now.depth : " + now.depth + " now.value : " + now.value);
            max = Math.max(max, now.depth);*/

            /*if(!visited[now.value-1]) {
                // 방문한적 없는 노드라면
                visited[now.value-1] = true;
                depths[now.value-1] = now.depth;

                for(int i=0; i<edge.length; i++){
                    if(edge[i][0] == now.value){
                        if(!visited[edge[i][1]-1]){
                            stack.push(new Node(now.depth+1, edge[i][1]));
                        }
                    }else if(edge[i][1] == now.value){
                        if(!visited[edge[i][0]-1]){
                            stack.push(new Node(now.depth+1, edge[i][0]));
                        }
                    }
                }
            }*/
        }

        int count = 0;
        for(int i=1; i<depths.length; i++){
            if(depths[i] == max) count++;
        }
        System.out.println("distances: \n" + Arrays.toString(depths));

        return count;
    }
    public static class Node {
        int depth;
        int value;

        public Node(int depth, int value) {
            this.depth = depth;
            this.value = value;
        }
    }
}
