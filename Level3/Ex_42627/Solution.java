package Level3.Ex_42627;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})); // 9
        // 반례
        System.out.println(solution(new int[][] {{0, 3}, {10, 1}})); // 2
        System.out.println(solution(new int[][] {{7, 8}, {3, 5}, {9, 6}})); // 9
        System.out.println(solution(new int[][] {{1, 4}, {7, 9}, {1000, 3}})); // 5
        System.out.println(solution(new int[][] {{0, 1}, {2, 2}, {2, 3}})); // 2
    }

    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int tot_time = 0;
        int now = 0;
        int idx = 0;

        while(!pq.isEmpty() || idx < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= now){
                pq.offer(new Pair(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(!pq.isEmpty() && pq.peek().req_time <= now){

                Pair p = pq.poll();
                tot_time += now + p.proc_time - p.req_time;
                now += p.proc_time;

                continue;
            }

            now++;
        }

        return tot_time/jobs.length;
    }

    public static class Pair implements Comparable<Pair>{
        int req_time;
        int proc_time;

        public Pair(int req_time, int proc_time){
            this.req_time = req_time;
            this.proc_time = proc_time;
        }

        public int compareTo(Pair o) {
            return this.proc_time - o.proc_time;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "req_time=" + req_time +
                    ", proc_time=" + proc_time +
                    '}';
        }
    }
}
