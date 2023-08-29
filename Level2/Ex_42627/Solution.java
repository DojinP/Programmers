package Level2.Ex_42627;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})); // 9
        System.out.println(solution(new int[][] {{0, 3}, {10, 1}})); // 2
        System.out.println(solution(new int[][] {{7, 8}, {3, 5}, {9, 6}})); // 9
        System.out.println(solution(new int[][] {{1, 4}, {7, 9}, {1000, 3}})); // 5
        System.out.println(solution(new int[][] {{0, 1}, {2, 2}, {2, 3}})); // 2
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int tot_time = 0;
        int now = 0;

        for(int i=0; i<jobs.length; i++) {
            pq.offer(new Pair(jobs[i][0], jobs[i][1]));
        }

        while(!pq.isEmpty()) {
            if(pq.peek().req_time <= now){
                Pair p = pq.poll();
                System.out.println(p);

                tot_time += now + p.proc_time - p.req_time;

                System.out.println("now : " + now);
                System.out.println("tot_time : " + tot_time);

                now += p.proc_time;

                System.out.println("processed now : " + now);
                continue;
            }

            now++;
        }

        System.out.println("final tot_time = " + tot_time);
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

            if(this.req_time == o.req_time)
                return this.proc_time - o.proc_time;
            else
                return this.req_time - o.req_time;
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
