// 평행
package Ex_120875;

/*
 * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
 *
 *  [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
 *   
 * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
        System.out.println(solution(new int[][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}}));
        System.out.println(solution(new int[][] {{1, 2}, {2, 1}, {3, 4}, {4, 5}}));
    }

    public static int solution(int[][] dots) {
        // 두 점을 지나는 직선의 기울기가 같으면 평행
        for(int i=0; i<dots.length-1; i++){
            for(int j=i+1; j<dots.length; j++){
                double lineAInc = (dots[j][1] - dots[i][1]) / (double)(dots[j][0] - dots[i][0]);
                int a = 0, b = 0;
                for(int k=0; k<dots.length; k++){
                    if(k != i && k != j) a = k;
                }
                for(int k=0; k<dots.length; k++){
                    if(k != i && k != j && k != a) b = k;
                }
                double lineBInc = (dots[b][1] - dots[a][1]) / (double)(dots[b][0] - dots[a][0]);

                if(lineAInc == lineBInc) return 1;
            }
        }

        return 0;
    }

    // Set<Double> incSet = new HashSet<Double>();
        // for(int i=0; i<dots.length-1; i++){
        //     for(int j=i+1; j<dots.length; j++){
        //         System.out.println(i + " " + j);
        //         if(!incSet.add((dots[j][1] - dots[i][1]) / (double)(dots[j][0] - dots[i][0]))){
        //             System.out.println(dots[j][1] + " " + dots[i][1] + " " + dots[j][0] + " " + dots[i][0]);
        //             System.out.println(incSet);
        //             System.out.println((dots[j][1] - dots[i][1]) / (double)(dots[j][0] - dots[i][0]));
        //             return 1;
        //         } 
        //     }
        // }
        // System.out.println(incSet);
}