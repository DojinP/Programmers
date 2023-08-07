package Ex_120821;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int[] tc1 = solution(new int[] {1, 2, 3, 4, 5});
        int[] tc2 = solution(new int[] {1, 0, 1, 1, 1, 3, 5});

        System.out.println(Arrays.toString(tc1));
        System.out.println(Arrays.toString(tc2));
    }

    public static int[] solution(int[] num_list) {
        List<Integer> num_list_as_list = Arrays.stream(num_list)
                                              .boxed()
                                              .collect(Collectors.toList());

        Collections.reverse(num_list_as_list);

        int[] answer = num_list_as_list.stream()
                                       .mapToInt(Integer::intValue)
                                       .toArray();

        return answer;
    }
}
