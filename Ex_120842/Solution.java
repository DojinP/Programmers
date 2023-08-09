package Ex_120842;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] result = solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 2);
        
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[(i*n)+j];
            }
        }

        return answer;
    }
}