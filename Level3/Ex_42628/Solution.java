// 이중우선순위큐
// https://school.programmers.co.kr/learn/courses/30/lessons/42628
package Level3.Ex_42628;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));

    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> min_pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<Integer>();
//        int max = Integer.MIN_VALUE;
        for(int i = 0; i < operations.length; i++) {
            String[] splitStr = operations[i].split(" ");

            char c = splitStr[0].charAt(0);
            int val = Integer.parseInt(splitStr[1]);

            if(c == 'I'){
//                if(val > max) max = val;
                min_pq.offer(val);
            }else if(c == 'D' && !min_pq.isEmpty()){
                if (val == 1){
                    int max = Collections.max(min_pq);
                    min_pq.remove(max);
                }else if (val == -1){
                    min_pq.poll();
                }
            }

        }

        return min_pq.isEmpty() ? new int[] {0, 0} : new int[] {Collections.max(min_pq), min_pq.poll()};
    }
}
