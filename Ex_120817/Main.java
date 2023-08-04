package Ex_120817;
public class Main {
    public static void main(String[] args) {
        // Test Case
        Solution s = new Solution();

        int[][] testCase = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}};

        for(int caseNo = 1; caseNo<=2; caseNo++){
            double ans = s.solution(testCase[caseNo-1]);
            System.out.println(ans);
        }
    }
}
