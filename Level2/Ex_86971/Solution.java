// 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
package Level2.Ex_86971;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    public static int solution(int n, int[][] wires) {
        int min = n;
        boolean[] visited = new boolean[n];

        for(int i=0; i<wires.length; i++) {
            Arrays.fill(visited, false);
            // 제거할 wire 선택
            int node1 = wires[i][0];
            int node2 = wires[i][1];

            visited[node1-1] = true;
            visited[node2-1] = true;

            // wire가 제거된 wires 배열 생성
            int[][] new_wires = new int[n-2][2];
            int idx = 0;
            for(int j=0; j<wires.length; j++) {
                if(i==j) continue;
                new_wires[idx][0] = wires[j][0];
                new_wires[idx][1] = wires[j][1];
                idx++;
            }

            // 전력망 크기 계산
            int result = calcStations(node1, node2, new_wires, visited);
            if(min > result) min = result;
        }

        return min;
    }

    public static int calcStations(int node1, int node2, int[][] wires, boolean[] visited) {
//        System.out.println("calcStations");

        Stack<Integer> node1_stack = new Stack<>();
        Stack<Integer> node2_stack = new Stack<>();

        // 초기 방문 노드와 연결된 노드 스택에 추가
        for(int i = 0; i < wires.length; i++) {
            if(wires[i][0] == node1){
                node1_stack.push(wires[i][1]);
            }else if(wires[i][1] == node1){
                node1_stack.push(wires[i][0]);
            }else if(wires[i][0] == node2){
                node2_stack.push(wires[i][1]);
            }else if(wires[i][1] == node2){
                node2_stack.push(wires[i][0]);
            }
        }

//        System.out.println("node1 stack: " + node1_stack);
//        System.out.println("node2 stack: " + node2_stack);

        // node1 의 전력망 크기 계산
        int node1_side_count = calcNodeCount(node1, wires, node1_stack, visited);

        // node2 의 전력망 크기 계산
        int node2_side_count = calcNodeCount(node2, wires, node2_stack, visited);

//        System.out.println("node1_side_count = " + node1_side_count);
//        System.out.println("node2_side_count = " + node2_side_count);

        // 전력망 크기 차이 반환 (절대값)
        return Math.abs(node1_side_count - node2_side_count);
    }

    public static int calcNodeCount(int node, int[][] wires, Stack<Integer> node_stack, boolean[] visited) {
//        System.out.println("calcNodeCount");
        int count = 1;
        while(!node_stack.isEmpty()){
            int now = node_stack.pop(); // 인접 노드 방문
            if(visited[now-1] == true) continue;    // 이미 방문한 노드일 경우 다음 노드 탐색
//            System.out.println("now 방문 : " + now);
            visited[now-1] = true; // 현재 노드 방문
            count++;

            // 다음 인접 노드 stack 에 추가
            for(int i=0; i<wires.length; i++){
                if(wires[i][0] == now) {
                    node_stack.push(wires[i][1]);
                }else if(wires[i][1] == now) {
                    node_stack.push(wires[i][0]);
                }
            }

//            System.out.println("now node stack: " + node_stack);
        }

        return count;
    }
}
