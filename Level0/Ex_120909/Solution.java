package Ex_120909;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(1000000));
    }

    public static int solution(int n) {
        if(n == 1) return 1;

        for(int i=2; i<=1000; i++){
            if(n/i==i && n%i == 0) return 1;
        }

        return 2;
    }
}