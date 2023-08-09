package Ex_120585;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 120, 140}, 190));
    }

    public static int solution(int[] array, int height) {
        int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > height) count++;
        }
        return count;
    }
}