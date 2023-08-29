package Level2.Ex_42627;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
//        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}, {1, 4}}));

    }

    public static int solution(int[][] jobs) {
        int tot_time = 0;
//         Arrays.sort(jobs, (o1, o2) -> {
//            return o1[0] - o2[0];
//        });

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int now = 0;
        int idx = 0;
        int target_time = -1;
        int processing_time = 0;
        boolean isRunning = false;

        while(idx < jobs.length || !pq.isEmpty() || isRunning) {
//            System.out.println("now : " + now);

            if(target_time == now) {
                // 실행중 = false, total 처리시간 합산, 마지막 프로세스 처리시간 초기화
                isRunning = false;
                tot_time += processing_time;
//                processing_time = 0;
            }

            // offer 조건 (index가 jobs 범위 내인 경우, 현재 시점의 프로세스 요청이 존재하는 경우)
            while(idx < jobs.length && jobs[idx][0] == now) {
//                System.out.println("offer");
                pq.offer(new Pair(jobs[idx][0], jobs[idx][1]));
//                System.out.println(pq);
                idx++;
            }

            // poll 조건 (실행중이 아닌 경우)
            if(!isRunning){
                if(!pq.isEmpty()){
                    // 가장 빠른 프로세스 poll, 현재 프로세스 종료 예정시간, 현재 프로세스 처리시간, 실행중 = true
//                    System.out.println("poll");
                    Pair proc = pq.poll();
//                    System.out.println(pq);
//                    System.out.println("now : " + proc);
                    target_time = now + proc.proc_time;
                    processing_time = target_time - proc.req_time;
                    isRunning = true;
                }
            }

            now++;
        }

//        System.out.println(tot_time);
        return (int)( tot_time / (double)jobs.length );
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
