package Level2.Ex_42842;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        // 가로 세로 길이의 최소 (w = 3, h = 3)
        int h = 3;

        return calcCarpetSize(h, brown, yellow);
    }

    public static int[] calcCarpetSize(int h, int brown, int yellow){
        final int size = brown + yellow;
        int w = 3;
        for(; h <= size / 2; h++){
            w = size / h;
            if(isBrown(w, h, brown) && isYellow(w, h, yellow)) break;
        }
        return new int[] {w, h};
    }

    public static boolean isBrown(int w, int h, int brown){
        // 테두리 격자의 길이 (Brown)
        // 2 * (가로길이 - 1) + 2 * (세로길이 - 1)
        return 2 * (w - 1) + 2 * (h - 1) == brown;
    }

    public static boolean isYellow(int w, int h, int yellow){
        // 내부 격자의 넓이 (Yellow)
        // (가로길이 - 2) * (세로길이 - 2)
        return (w - 2) * (h - 2) == yellow;
    }
}
