// https://school.programmers.co.kr/learn/courses/30/lessons/42862
package Level1.Ex_42862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {

    public static void main(String[] args) {
//        System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
//        System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
//        System.out.println(solution(3, new int[] {3}, new int[] {1}));
//        System.out.println(solution(3, new int[] {1, 2, 3}, new int[] {2, 3, 4}));
        System.out.println(solution(5, new int[] {1, 3}, new int[] {2, 4}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> losts = new ArrayList<Integer>();
        List<Integer> reserves = new ArrayList<Integer>();
        List<Integer> students = new ArrayList<Integer>();

        // lost, reserve 배열이 정렬되어있다는 보장이 없다.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=1; i<=n; i++) students.add(i);

        for(int el : reserve) reserves.add(el);

        for(int el : lost){
            // 여벌 옷 있는 학생이 옷을 잃어버린 경우
            if(reserves.indexOf(el) != -1){
                reserves.remove(reserves.indexOf(el));
            }else{
                losts.add(el);
            }
        }

        for(int el : losts) {
            if(el-1 > 0 && el+1 <= n) {
                if(reserves.indexOf(el-1) != -1) {
                    reserves.remove(reserves.indexOf(el-1));
                }else if(reserves.indexOf(el+1) != -1) {
                    reserves.remove(reserves.indexOf(el+1));
                }else{
                    students.remove(students.indexOf(el));
                }
            }else {
                if(el-1 > 0) {
                    if(reserves.indexOf(el-1) != -1) {
                        reserves.remove(reserves.indexOf(el-1));
                    }else{
                        students.remove(students.indexOf(el));
                    }
                }else if(el+1 <= n) {
                    if(reserves.indexOf(el+1) != -1) {
                        reserves.remove(reserves.indexOf(el+1));
                    }else{
                        students.remove(students.indexOf(el));
                    }
                }else {
                    students.remove(students.indexOf(el));
                }
            }
        }

        System.out.println(reserves);
        System.out.println(students);

        return students.size();

    }
}
