// https://school.programmers.co.kr/learn/courses/30/lessons/49190
package Level5.Ex_49190;

import java.util.*;

public class 방의_개수 {

    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) {
        // System.out.println(solution(new int[] {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}));
        System.out.println(solution(new int[] {6, 0, 3, 0, 5, 2, 6, 0, 3, 0, 5}));
    }

    public static int solution(int[] arrows) {
        HashSet<Pair> pointMap = new HashSet<>();
        //HashMap<Pair, Integer> pointMap = new HashMap<>();

        int count = 0;

        Pair now = new Pair(0, 0, -1);

        // 시작점 방문
        //pointMap.add(now);

        for(int i=0; i<arrows.length; i++){

            int nx = now.x + dx[arrows[i]];
            int ny = now.y + dy[arrows[i]];
            Pair next = new Pair(nx, ny, arrows[i]);

            // 다음 위치 방문한 적 없다면
            if(!pointMap.contains(next)){
                // 다음 위치 방문 처리
                pointMap.add(next);
            }else{
                // 다음 위치 방문한 적 있다면
                // 방이 생기기 직전의 위치를 방문한 적이 없다면 신규 방이 생성 됨
                System.out.println("이미 방문한 곳 들렀다!");

                // 직전 위치
                if(!pointMap.contains(now)) {
                    System.out.print(now);
                    System.out.println(" 방문한적 없다");
                    count++;
                    // 지금 위치 방문 처리
                    pointMap.add(now);
                }
            }

            // 현재 위치 이동
            now = next;

            System.out.println("현재 위치 : (" + (now.x) + ", " + (now.y) + ")");

        }

        System.out.println(pointMap);

        return count;
    }

    public static class Pair{
        int x;
        int y;
        int from;

        public Pair(int x, int y, int from) {
            this.x = x;
            this.y = y;
            this.from = from;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getFrom() {
            return from;
        }

        @Override
        public String toString() {
            return "(" +
                    x +
                    ", " + y +
                    ", " + from +
                    ")";
        }

        @Override
        public int hashCode() {
            final int PRIME = 31;
            return (((PRIME * 1 + getX()) * PRIME) + getY()) * PRIME + getFrom();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(obj == this) return true;

            if(obj instanceof Pair){
                Pair targetObj = (Pair) obj;

                return this.getX() == targetObj.getX() && this.getY() == targetObj.getY() && this.getFrom() == targetObj.getFrom();
            }

            return false;
        }
    }

}
