// 더 맵게
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
package Level2.Ex_42626;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        Queue<Integer> scovilleQueue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        int count = 0;
        while(scovilleQueue.peek() < K && scovilleQueue.size() >= 2){
            int lowest_sco1 = scovilleQueue.poll();
            int lowest_sco2 = scovilleQueue.poll();

            int mixed_sco = lowest_sco1 + (lowest_sco2 * 2);

            scovilleQueue.offer(mixed_sco);

            count++;
        }

        return scovilleQueue.peek() >= K ? count : -1;
    }
}
