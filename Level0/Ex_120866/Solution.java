// 안전지대
package Ex_120866;

/*
 * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
 * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
 */

import java.util.Arrays;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) {
        // System.out.println(solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}})); //
        // System.out.println(solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][] {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
    }

    public static int solution(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1){
                    for(int y = i-1; y <= i+1; y++){
                        if(y < 0 || y >= board.length) continue; // y가 범위를 벗어나면 미시행
                        for(int x = j-1; x <= j+1; x++){
                            if(x < 0 || x >= board.length) continue; // x가 범위를 벗어나면 미시행

                            board[y][x] = board[y][x] != 1 ? 2 : 1;
                        }
                    }
                }
            }
        }

        return (int)Stream.of(board).flatMapToInt(a -> Arrays.stream(a)).filter(i -> i == 0).count();
    }
}