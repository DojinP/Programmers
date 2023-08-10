package Ex_120819;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] tc1 = solution(5500);
        int[] tc2 = solution(15000);

        System.out.println(Arrays.toString(tc1));
        System.out.println(Arrays.toString(tc2));
    }

    public static int[] solution(int money){
        int aa_count = money / 5500;
        int changes = money % 5500;
        
        int[] answer = {aa_count, changes};
        return answer;
    }
}
