package Level2.Ex_1844;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

    public static int solution(int[][] maps) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        int n = maps[0].length-1;
        int m = maps.length-1;

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1)); // 0, 0 을 방문한 것이므로 count 1 초기화

        // count 값을 지역변수로 선언하면 BFS 특성상 최단 거리를 계산할 수 없다.
        // int count = 0;
        // 해결방안 1. Queue 의 타입인 Location 내부에 count 값을 추가하여 add 시 count 값을 초기화
        // 해결방안 2. 기존에 주어진 2차원 배열 map의 값을 count 값으로 변환하여 마지막에 (n, m) 위치의 값을 반환한다.

        while(!queue.isEmpty()){
            Location now = queue.poll();
            if(now.x == n && now.y == m) return now.count;

            for(int i=0; i<4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                if(x < 0 || x > n || y < 0 || y > m) continue;
                if(maps[y][x] == 1) {
                    maps[y][x] = 0;
                    queue.add(new Location(x, y, now.count+1));
                }
            }
        }

        return -1;
    }

    public static class Location {
        int x, y;
        int count;

        Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
