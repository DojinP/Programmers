// https://school.programmers.co.kr/learn/courses/30/lessons/84021
package Level3.Ex_84021;

import java.util.*;

public class 퍼즐_조각_채우기 {
    static List<Figure> tableFigureList;
    static List<Figure> gameBoardFigureList;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        System.out.println(solution(new int[][] {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
                new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}));
    }

    public static int solution(int[][] game_board, int[][] table) {
        tableFigureList = new ArrayList<>();
        gameBoardFigureList = new ArrayList<>();

        // table 탐색
        for(int y=0; y<table.length; y++){
            for(int x=0; x<table[0].length; x++){
                // 이미 체크된 도형은 2로 표기
                if (table[y][x] == 1) {
                    table[y][x] = 2; // 방문 처리
                    bfs(new Point(x, y), table, tableFigureList);
                }
            }
        }

        // game_board 탐색
        for(int y=0; y<game_board.length; y++){
            for(int x=0; x<game_board[0].length; x++){
                // 이미 체크된 도형은 2로 표기
                if (game_board[y][x] == 1) {
                    game_board[y][x] = 2; // 방문 처리
                    bfs(new Point(x, y), game_board, gameBoardFigureList);
                }
            }
        }

        // tableFigureList 정렬 (Point[] 사이즈 내림차순)
//        Collections.sort(tableFigureList, new Comparator<Figure>() {
//            @Override
//            public int compare(Figure o1, Figure o2) {
//                return o2.points.size() - o1.points.size();
//            }
//        });

        // table 내부 도형 최적화
        for(Figure figure : tableFigureList){
            optimizeFigure(figure);
        }

        for(Figure figure : gameBoardFigureList){
            optimizeFigure(figure);
        }

        // figureList 출력
        printFigureList(tableFigureList);
//        printFigureList(gameBoardFigureList);

        return checkFit(tableFigureList, gameBoardFigureList);
    }

    public static int checkFit(List<Figure> tableFigureList, List<Figure> gameBoardFigureList) {
        int count = 0;

        for(int i = 0; i< tableFigureList.size(); i++){
            Figure figure = tableFigureList.get(i);
            int sub = Math.min(point.x, point.y);
            int x = point.x - sub;
            int y = point.y - sub;
            for(Point p : figure.points){
                // 이부분에 들어갈 로직이 궁금해
            }
        }

        return count;
    }

    public static void bfs(Point point, int[][] table, List<Figure> figureList){
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

    public static void optimizeFigure(Figure figure){
        int minX = 100, minY = 100;
        int maxX = -1, maxY = -1;
        for(Point p : figure.points){
            if(p.x < minX) minX = p.x;
            if(p.y < minY) minY = p.y;
            if(p.x > maxX) maxX = p.x;
            if(p.y > maxY) maxY = p.y;
        }

        figure.sizeX = maxX + 1;
        figure.sizeY = maxY + 1;

        for(Point p : figure.points){
            p.x -= minX;
            p.y -= minY;
        }
    }

    public static void rotateFigure(Figure figure) {
        for(Point p : figure.points){
            p.y = p.x;
            p.x = figure.sizeY - p.x;
        }

        // figure의 sizeX 와 sizeY 값 switching
        figure.sizeX += figure.sizeY; // x = 4 + y = 3 ==> x = 7
        figure.sizeY = figure.sizeX - figure.sizeY; // x = 7 - y = 3 ==> y = 4
        figure.sizeX -= figure.sizeY; // x = 7 - y = 4 ==> x = 3
    }

    public static void printFigureList(List<Figure> figureList){
        for(Figure f : figureList){
            for(Point p : f.points){
                System.out.print("[" + p.x + ", " + p.y + "]" + " ");
            }
            System.out.println();
        }
    }

    public static class Figure{
        List<Point> points;
        int sizeX;
        int sizeY;

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
