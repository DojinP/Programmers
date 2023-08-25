package Level2.Ex_42583;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
//        System.out.println(solution(100, 100, new int[]{10}));
//        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int now = 0;
        Queue<Pair> truck_in_bridge = new LinkedList<Pair>();
        Queue<Integer> waiting_truck = new LinkedList<Integer>(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));

        System.out.println("대기 트럭");
        for (int el : waiting_truck) {
            System.out.print(el + " ");
        }
        System.out.println();


        while (!truck_in_bridge.isEmpty() || !waiting_truck.isEmpty()) {
            // 전체 시간, 트럭이 다리에 오른 시간 계산
            now++;
            truck_in_bridge.forEach(Pair::addTime);

            if(!truck_in_bridge.isEmpty()){
                if(truck_in_bridge.peek().time == bridge_length) truck_in_bridge.poll();
            }

            if(!waiting_truck.isEmpty()){
                if(waiting_truck.peek() + truck_in_bridge.stream().mapToInt(Pair::getWeight).sum() <= weight) truck_in_bridge.offer(new Pair(0, waiting_truck.poll()));
            }

            System.out.println("시간 : " + now);
            System.out.println("다리 위 트럭");
            for (Pair p : truck_in_bridge) {
                System.out.printf(p.time + " " + p.weight + "\n");
            }
            System.out.println();
        }

        return now;
    }

    public static class Pair {
        int time;
        int weight;

        Pair(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }

        void addTime() {
            time++;
        }

        public int getTime() {
            return time;
        }

        public int getWeight() {
            return weight;
        }
    }
}