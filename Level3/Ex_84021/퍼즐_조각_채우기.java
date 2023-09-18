// https://school.programmers.co.kr/learn/courses/30/lessons/84021
package Level3.Ex_84021;

import java.util.*;

public class 퍼즐_조각_채우기 {
    static List<Figure> tableFigureList;
    static List<Figure> gameBoardFigureList;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        /*System.out.println(solution(new int[][] {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}},
                new int[][] {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}));*/

        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}},
                new int[][] {{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}}));
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
                    bfs(new Point(x, y), table, tableFigureList, 1);
                }
            }
        }

        // game_board 탐색
        for(int y=0; y<game_board.length; y++){
            for(int x=0; x<game_board[0].length; x++){
                // 이미 체크된 도형은 2로 표기
                if (game_board[y][x] == 0) {
                    game_board[y][x] = 2; // 방문 처리
                    bfs(new Point(x, y), game_board, gameBoardFigureList, 0);
                }
            }
        }

        // table 내부 도형 최적화
        optimizeFigureList(tableFigureList);
        optimizeFigureList(gameBoardFigureList);

//        printFigure(tableFigureList.get(1));
//        rotateFigure(tableFigureList.get(1));
//        optimizeFigure(tableFigureList.get(1));
//        printFigure(tableFigureList.get(1));
//        rotateFigure(tableFigureList.get(1));
//        optimizeFigure(tableFigureList.get(1));
//        printFigure(tableFigureList.get(1));
//        rotateFigure(tableFigureList.get(1));
//        optimizeFigure(tableFigureList.get(1));
//        printFigure(tableFigureList.get(1));

        // tableFigureList
        System.out.println("tableFigureList");
        printFigureList(tableFigureList);
        // gameBoardFigureList
        System.out.println("gameBoardFigureList");
        printFigureList(gameBoardFigureList);

        return checkFit(tableFigureList, gameBoardFigureList);
    }

    public static int checkFit(List<Figure> tableFigureList, List<Figure> gameBoardFigureList) {
        // 일치하는 블럭의 개수
        int count = 0;

        for(Figure gameBoardFigure : gameBoardFigureList){
            for(Figure tableFigure : tableFigureList) {
                List<Point> gameBoardPoints = gameBoardFigure.points;
                List<Point> tablePoints = tableFigure.points;

                if(tableFigure.visited || gameBoardFigure.visited || gameBoardPoints.size() != tablePoints.size()) continue;

                // tableFigure 의 요소들을 회전하면서 gameBoard의 요소들과 비교
                for(int i=0; i<4; i++){
                    for(int j=0; j<gameBoardPoints.size(); j++){
                        Point gp = gameBoardPoints.get(j);
                        Point tp = tablePoints.get(j);
                        if(gp.x == tp.x && gp.y == tp.y) {
                            if(j == gameBoardPoints.size()-1){
                                gameBoardFigure.visited = true;
                                tableFigure.visited = true;
                                count += gameBoardPoints.size();
                            }
                        }
                        else break;
                    }
                    if(!gameBoardFigure.visited || !tableFigure.visited) {
                        rotateFigure(tableFigure);
                        optimizeFigure(tableFigure);
                    }
                    else break;
                }
            }
        }

        return count;
    }

    public static void bfs(Point point, int[][] table, List<Figure> figureList, int target){
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

                if(table[ny][nx] == target) {
                    table[ny][nx] = 2; // 방문 처리
                    queue.add(new Point(nx, ny));
                }
            }
        }

        figureList.add(figure);
    }

    public static void optimizeFigureList(List<Figure> figureList){
        for(Figure figure : figureList){
            optimizeFigure(figure);
        }
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

        figure.size = Math.max(maxX-minX, maxY-minY);

        for(Point p : figure.points){
            p.x -= minX;
            p.y -= minY;
        }

        Collections.sort(figure.points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                else
                    return o1.x - o2.x;
            }
        });
    }
    
    // 90도 회전
    public static void rotateFigure(Figure figure) {
        for(Point p : figure.points){
            int temp = p.y;
            p.y = p.x;
            p.x = figure.size - temp;
        }

        // 회전 후 정렬
        Collections.sort(figure.points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                else
                    return o1.x - o2.x;
            }
        });

        // figure의 sizeX 와 sizeY 값 switching
//        figure.sizeX += figure.sizeY; // x = 4 + y = 3 ==> x = 7
//        figure.sizeY = figure.sizeX - figure.sizeY; // x = 7 - y = 3 ==> y = 4
//        figure.sizeX -= figure.sizeY; // x = 7 - y = 4 ==> x = 3
    }

    public static void printFigureList(List<Figure> figureList){
        for(Figure f : figureList){
            printFigure(f);
        }
    }

    public static void printFigure(Figure figure){
        for(Point p : figure.points){
            System.out.print("[" + p.y + ", " + p.x + "]" + " ");
        }
        System.out.println();
    }

    public static class Figure{
        List<Point> points;
//        int sizeX;
//        int sizeY;
        int size;
        boolean visited;

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
