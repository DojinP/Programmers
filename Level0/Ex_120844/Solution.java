package Ex_120844;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {4, 455, 6, 4, -1, 45, 6}, "left")));
    }

    public static int[] solution(int[] numbers, String direction) {
        if(direction.equals("left")){
            int temp = numbers[0];
            for(int i=0; i<numbers.length-1; i++){
                numbers[i] = numbers[i+1];
            }
            numbers[numbers.length-1] = temp;
        }else{
            int temp = numbers[numbers.length-1];
            for(int i=numbers.length-1; i>0; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = temp;
        }
        return numbers;
    }
}