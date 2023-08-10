package Ex_120830;

class Solution {
    public int solution(int n, int k) {
        // 서비스 계산
        int service = n/10;
        k = k - service;
        
        int answer = n * 12000 + k * 2000;
        
        return answer;
    }
}