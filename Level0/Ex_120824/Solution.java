package Ex_120824;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] result = solution(new int[] {1,3,5,7});

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] num_list) {
        int odd_count = 0;
        int even_count = 0;

        for(int i=0; i<num_list.length; i++){
            if(num_list[i] % 2 == 0) even_count++;
            else odd_count++;
        }

        int[] answer = {even_count, odd_count};
        return answer;
    }
}
