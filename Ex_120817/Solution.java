package Ex_120817;

class Solution {
    public double solution(int[] numbers) {
        
        int tot = 0;

        for(int i=0; i<numbers.length; i++){
            tot += numbers[i];
        }

        double answer = tot/numbers.length;

        return answer;
    }
}