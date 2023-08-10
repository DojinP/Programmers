package Ex_120833;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] result1 = solution(new int[] {1, 2, 3, 4, 5}, 1, 3);
        int[] result2 = solution(new int[] {1, 3, 5}, 1, 2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int[] solution(int[] numbers, int num1, int num2) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++){
            if(num1 <= i && i <= num2) result.add(numbers[i]);
        }

        int[] answer = result.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();

        return answer;
    }
}