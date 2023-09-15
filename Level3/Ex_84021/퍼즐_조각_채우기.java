// https://school.programmers.co.kr/learn/courses/30/lessons/84021
package Level3.Ex_84021;

import java.util.*;

public class 퍼즐_조각_채우기 {
    static List<Figure> figureList;
    static boolean[][] visited;
    static boolean isCheckingFigure;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        System.out.println(solution(new int[][] {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
                new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}));
    }

    public static int solution(int[][] game_board, int[][] table) {
        figureList = new ArrayList<>();
        visited = new boolean[game_board.length][game_board[0].length];

//        for(int[] ele : table){
//            for(int el : ele){
//                System.out.print(el + " ");
//            }
//            System.out.println();
//        }
        // table 도형 구하여 저장하는 프로세스
        for(int x=0; x<table.length; x++){
            for(int y=0; y<table[0].length; y++){
                // 이미 체크된 도형은 2로 표기
                if (table[y][x] == 1) {
                    table[y][x] = 2; // 방문 처리
                    getTableBlockBFS(new Point(x, y), table);
                }
            }
        }

        //System.out.println(figureList);
//        for(Figure f : figureList){
//            for(Point p : f.points){
//                System.out.print("[" + p.x + ", " + p.y + "]" + " ");
//            }
//            System.out.println();
//        }

        // game_board 와 비교하는 프로세스



        return 0;
    }

    public static void rotateBlock(){

    }

    public static void getTableBlockBFS(Point point, int[][] table){
        Figure figure = new Figure(new ArrayList<>());
        Queue<Point> queue = new LinkedList<>();

        queue.add(point);

        while(!queue.isEmpty()){
            Point now = queue.poll();
            figure.points.add(now);

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= table[0].length || ny >= table.length) continue;

                if(table[ny][nx] == 1) {
                    table[ny][nx] = 2; // 방문 처리
                    queue.add(new Point(nx, ny));
                }
            }
        }

        figureList.add(figure);
    }

    public static class Figure{
        List<Point> points;

        Figure(List<Point> point){
            this.points = point;
        }

        @Override
        public String toString() {
            return "Figure{" +
                    "point=" + points +
                    '}';
        }
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
