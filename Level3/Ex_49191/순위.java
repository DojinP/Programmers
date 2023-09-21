// https://school.programmers.co.kr/learn/courses/30/lessons/49191
package Level3.Ex_49191;

public class 순위 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); // 2
    }

    public static int solution(int n, int[][] results) {
        // Floyd-Warshall 알고리즘 응용
        final int INF = 99999;
        int[][] adj = new int[n][n];


        // 인접행렬 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) adj[i][j] = 0;
                else adj[i][j] = INF;
            }
        }
        for(int i=0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            adj[a-1][b-1] = 1; // 승
            adj[b-1][a-1] = -1; // 패
        }

        // 최단거리행렬 초기화
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            dist[i] = adj[i].clone();
        }

        // 플로이드 워셜 알고리즘 수행
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                // row 선수가 col 선수를 이긴경우
                if(dist[row][col] == 1){
                    for(int i=0; i<n; i++){
                        // col 선수가 승리한 선수는 row 선수도 승리할 수 있다.
                        if(dist[col][i] == 1) {
                            dist[row][i] = 1;
                            dist[i][row] = -1;
                        }
                    }
                }
                // row 선수가 col 선수에게 패배한 경우
                else if(dist[row][col] == -1){
                    for(int i=0; i<n; i++){
                        // row 선수가 승리한 선수는 col 선수도 승리를 거둘 수 있다.
                        if(dist[row][i] == 1) {
                            dist[col][i] = 1;
                            dist[i][col] = -1;
                        }
                    }
                }
            }
        }


        int count = 0;

        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                if(dist[i][j] == 1 || dist[i][j] == -1) temp++;
            }
            // 승패기록이 n-1 번 존재한다면 랭킹확인이 가능하다.
            if(temp == n-1) count++;
        }

        return count;
    }
}
