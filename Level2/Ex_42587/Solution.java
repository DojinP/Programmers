// 프로세스
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
package Level2.Ex_42587;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) { 
        System.out.println(solution(new int[] {1, 1, 3, 1, 1, 1}, 3));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Proc> queue = new LinkedList();

        // 큐에 저장
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Proc(i, priorities[i]));
        }

        // queue.forEach(System.out::print);
        //     System.out.println();

        int count = 1;
        
        while(!queue.isEmpty()){
            Proc max = new Proc(-1, -1);
            for(Proc p : queue) {
                if(p.getPriority() > max.getPriority()){
                    max.setIndex(p.getIndex());
                    max.setPriority(p.getPriority());
                }
            }

            for(int i=0; i<queue.size(); i++){
                Proc pt = queue.poll();
                if(pt.getPriority() == max.getPriority()){
                    if(pt.getIndex() == location) return count;
                    else {
                        count++;
                        break;
                    }
                }else if(pt.getPriority() < max.getPriority()){
                    queue.offer(pt);
                }
            }

            // queue.forEach(System.out::print);
            // System.out.println();
            
        }

        return count;
    }

    public static class Proc{
        int index;
        int priority;
        
        Proc(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getIndex() {
            return index;
        }

        public int getPriority() {
            return priority;
        }

        public String toString(){
            return "[" + index + ":" + priority + "]";
        }
    }
}