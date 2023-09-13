// https://school.programmers.co.kr/learn/courses/30/lessons/87694
package Level3.Ex_87694;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 직사각형 변의 길이가 아닌 좌표를 통해 표현되므로 겹치는 부분의 표현이 애매해졌다. (ex. 표현 방식 때문에 실제로는 꼭지점이지만 직선처럼 표기가 되는 부분)
        // 해결방안. map의 scale 을 2배로 늘려 최단거리를 계산한 후 절반되는 값으로 반환
        int map[][] = new int[101][101];    // 기존 1 ~ 50 까지 제시되는 맵의 크기

        for(int i=0; i<rectangle.length; i++){
            int startX = rectangle[i][0];
            int startY = rectangle[i][1];
            int endX = rectangle[i][2];
            int endY = rectangle[i][3];
            setMap(startX*2, startY*2, endX*2, endY*2, map);
        }

//        printMap(map);

        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY, map);

        printMap(map);

        int result = map[2*itemY][2*itemX];

        return result/2;
    }

    public static void setMap(int startX, int startY, int endX, int endY, int[][] map){
        // 테두리에만 값을 추가하는 방식 (구현 에러)
        /*for(int i=startX; i<endX; i++){
            map[startY][i]++;
            map[endY][i+1]++;
        }
        for(int i=startY; i<endY; i++){
            map[i+1][startX]++;
            map[i][endX]++;
        }*/

        // 테두리에는 -1의 값을, 맵의 내부이면 -2, 맵 바깥은 그대로 0을 넣는 방식
        for(int i=startY; i<=endY; i++){
            for(int j=startX; j<=endX; j++){
                // 기존 맵에 2로 표기된 맵좌표는 사전에 세팅한 도형의 내부이므로 다음 도형의 테두리와 겹치더라도 1로 변경되어서는 안된다.
                if(map[i][j] == -2) continue;

                // 테두리의 경우
                if(i == startY || i == endY || j == startX || j == endX){
                    map[i][j] = -1;
                }else{
                    map[i][j] = -2;
                }
            }
        }
    }

    public static void printMap(int[][] map){

        for(int i=map.length-1; i>=0; i--){
            for(int j=0; j<map[0].length-1; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//        for(int[] elArr : map){
//            for(int el : elArr){
//                System.out.print(el + " ");
//            }
//            System.out.println();
//        }
    }

    public static void bfs(int characterX, int characterY, int itemX, int itemY, int[][] map){
        Queue<Pair> queue = new LinkedList<>();

        // 상 하 좌 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        // init
        queue.add(new Pair(characterX, characterY, 0));
        map[characterY][characterX] = 0; // 방문 처리

        while(!queue.isEmpty()){
            Pair now = queue.poll();

            int x = now.pointX;
            int y = now.pointY;
            int distance = now.distance;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 바깥의 경우 예외처리
                if(ny > map.length-1 || nx > map[0].length-1 || ny < 0 || nx < 0) continue;

                // 테두리인 경우 방문
                if(map[ny][nx] == -1){
                    queue.add(new Pair(nx, ny, distance+1));
                    map[ny][nx] = distance+1; // 방문 처리
                }
            }
        }

    }

    public static class Pair{
        int pointX;
        int pointY;
        int distance;

        Pair(int x, int y, int distance){
            pointX = x;
            pointY = y;
            this.distance = distance;
        }
    }
}
