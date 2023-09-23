// https://school.programmers.co.kr/learn/courses/30/lessons/42862
package Level1.Ex_42862;

import java.util.Arrays;
import java.util.List;

public class 체육복 {

    public static void main(String[] args) {
//        System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
//        System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
//        System.out.println(solution(3, new int[] {3}, new int[] {1}));
        System.out.println(solution(3, new int[] {1, 2, 3}, new int[] {2, 3, 4}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        n -= lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            if(reserve == null) break;

            System.out.println("lost");
            System.out.println(Arrays.toString(lost));

            System.out.println("reserve");
            System.out.println(Arrays.toString(reserve));


            int target = lost[i];

            int idx = hasTarget(reserve, target);
            if (idx != -1 && hasTarget(lost, target) == -1) {
                reserve = deleteReserveElement(reserve, idx);
                n++;
                continue;
            }

            if (target - 1 >= 0) idx = hasTarget(reserve, target - 1);
            if (idx != -1) {
                reserve = deleteReserveElement(reserve, idx);
                n++;
                continue;
            }

            if (target + 1 <= n) idx = hasTarget(reserve, target + 1);
            if (idx != -1) {
                reserve = deleteReserveElement(reserve, idx);
                n++;
            }
        }

        return n;
    }

    public static int[] deleteReserveElement(int[] reserve, int index) {
        if(reserve.length-1 == 0) return null;
        int[] temp = new int[reserve.length - 1];
        int originIdx = 0;

        for (int j = 0; j < temp.length; j++) {
            if (j == index) {
                originIdx++;
            }
            temp[j] = reserve[originIdx];
            originIdx++;
        }

        return temp;
    }

    public static int hasTarget(int[] reserve, int target) {
        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] == target) return i;
        }
        return -1;
    }
}
