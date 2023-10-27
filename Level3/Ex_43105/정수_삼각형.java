package Level3.Ex_43105;

import java.util.ArrayList;
import java.util.List;

public class 정수_삼각형 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        //List<Integer> max_list = new ArrayList<>();
        int size = triangle.length;
        int max = 0;
        int temp_max = 0;

        // 마지막 줄의 최댓값과 그 index 값을 구함
        /*int max_index = 0;
        for(int i=0; i<triangle[size-1].length; i++) {
            if(triangle[size-1][i] > max) {
                max = triangle[size-1][i];
                max_index = i;
            }
        }*/

        //max_list.add(max);
        //System.out.println(max);

        for(int n=0; n<triangle[size-1].length; n++) {
            int max_index = n;
            temp_max = triangle[size-1][max_index];

            for (int i = size - 2; i >= 0; i--) {
                // n-1 번째 줄부터 최댓값을 구하기
                int now_index;
                if (max_index == 0) {
                    // 최댓값의 위치가 현재 줄에서 첫 번째 값이라면
                    now_index = 0;
                } else if (max_index == triangle[i + 1].length - 1) {
                    // 최댓값의 위치가 현재 줄에서 마지막 값이라면
                    now_index = triangle[i].length - 1;

                } else {
                    if (triangle[i][max_index - 1] >= triangle[i][max_index]) {
                        now_index = max_index - 1;
                    } else {
                        now_index = max_index;
                    }
                }

                //max_list.add(triangle[i][now_index]);
                //max += triangle[i][now_index];
                temp_max += triangle[i][now_index];
                max_index = now_index;
            }

            if(temp_max > max) max = temp_max;
        }

        //System.out.println(max_list);

        return max;
    }
}
