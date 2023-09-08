// https://school.programmers.co.kr/learn/courses/30/lessons/43165
package Level2.Ex_43165;

public class 타겟_넘버 {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[] {4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        // 선택을 안하는 경우는 없으므로 visited 불필요
        //boolean[] visited = new boolean[numbers.length];
        count = 0;

        dfs(numbers, 0, 0, target);

        return count;
    }


    public static void dfs(int[] numbers, int start, int tot, int target) {
        if(start == numbers.length){
            if(tot == target) count++;
            return;
        }

        dfs(numbers, start+1, tot+numbers[start], target);
        dfs(numbers, start+1, tot-numbers[start], target);
    }
}

