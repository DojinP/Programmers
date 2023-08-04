package Ex_120815;

class Solution {
    public void solution(int n) {
        
        int gcd = gcd(n, 6);
        int lcm = n * 6 / gcd;

        System.out.println(lcm/6);
    }

    // 최대 공약수
    public int gcd(int a, int b){
        // r = (a % b)이 0이되는 시점의 b를 반환
        while(a % b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return b;
    }
}