// 합성수 찾기
package Ex_120846;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        if(n < 4) return 0;

        int answer = 0;

        for(int i=4; i<=n; i++){
            for(int j=2; j<i; j++){
                if(i % j == 0) {
                    answer++;
                    break;
                } 
            }
        }
        
        return answer;
    }
}