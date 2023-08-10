package Ex_120854;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test Case
        Solution s = new Solution();

        String[][] testCase = {{"We", "are", "the", "world!"}, {"I", "Love", "Programmers."}};

        for(int caseNo = 1; caseNo<=2; caseNo++){
            int[] ans = s.solution(testCase[caseNo-1]);
            System.out.println(Arrays.toString(ans));
        }
    }
}
