package Ex_120910;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(10, 15));
    }

    public static int solution(int n, int t) {
        int answer = n;
        for(int i=1; i<=t; i++){
            answer *= 2;
        }
        return answer;
    }
}