package Ex_120583;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 2, 3, 4}, 1));
    }

    public static int solution(int[] array, int n) {
        int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == n) count++;
        }
        return count;
    }
}