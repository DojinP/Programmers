package Ex_120898;
public class Main {
    public static void main(String[] args) {
        // Test Case
        Solution s = new Solution();

        String[] testCase = {"happy birthday!", "I love you~"};

        for(int caseNo = 1; caseNo<=2; caseNo++){
            double ans = s.solution(testCase[caseNo-1]);
            System.out.println(ans);
        }
    }
}
