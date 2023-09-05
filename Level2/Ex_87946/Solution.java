
// 피로도
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
package Level2.Ex_87946;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }

    public static int solution(int k, int[][] dungeons) {

        List<Pair> dungeonList = new ArrayList<Pair>();
        boolean[] visited = new boolean[dungeons.length];

        int max_count = backtracking(dungeons, k, dungeonList, visited);

        return max_count;
    }

    public static int backtracking(int[][] dungeons, int fatigue, List<Pair> dungeonList,  boolean[] visited) {
        int max = dungeonList.size();
        boolean end = true;
        // 전부 방문했으면 탈출
        for (boolean isVisited : visited) {
            if (!isVisited) {
                end = false;
                break;
            }
        }
        if (end) {
            System.out.println(dungeonList);
            return max;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                boolean isAdded = false;
                if (dungeons[i][0] <= fatigue && dungeons[i][1] <= fatigue) {
                    isAdded = true;
                    dungeonList.add(new Pair(dungeons[i][0], dungeons[i][1]));
                    fatigue -= dungeons[i][1];
                }

                max = Math.max(max, backtracking(dungeons, fatigue, dungeonList, visited));

                visited[i] = false;
                if (isAdded) {
                    dungeonList.remove(dungeonList.size() - 1);
                    fatigue += dungeons[i][1];
                }
            }
        }

        return max;
    }

    public static class Pair {
        private int min_req_fatigue;
        private int consume_fatigue;

        Pair(int min_req_fatigue, int consume_fatigue){
            this.min_req_fatigue = min_req_fatigue;
            this.consume_fatigue = consume_fatigue;
        }

        public int getMin_req_fatigue() {
            return min_req_fatigue;
        }

        public int getConsume_fatigue() {
            return consume_fatigue;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "min_req_fatigue=" + min_req_fatigue +
                    ", consume_fatigue=" + consume_fatigue +
                    '}';
        }
    }
}
