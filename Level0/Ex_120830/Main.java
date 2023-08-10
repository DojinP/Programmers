package Ex_120830;
public class Main {
    public static void main(String[] args) {
        // Test Case
        Solution s = new Solution();

        int[][] testCase = {{10, 3}, {64, 6}};

        for(int caseNo = 1; caseNo<=2; caseNo++){
            double ans = s.solution(testCase[caseNo-1][0], testCase[caseNo-1][1]);
            System.out.println((int)ans);
        }
    }
}
