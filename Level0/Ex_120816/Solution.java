package Ex_120816;

class Solution {
    public void solution(int slice, int n) {
        
        int result = n / slice;
        if(n % slice != 0){
            result++;
        }

        System.out.println(result);
    }
}