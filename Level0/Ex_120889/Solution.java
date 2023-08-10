// 삼각형의 완성조건 (1)
// https://school.programmers.co.kr/learn/courses/30/lessons/120889
package Ex_120889;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {199, 72, 222}));
    }

    public static int solution(int[] sides) {
        int tot = 0;
        int max = 0;
        for(int i=0; i<sides.length; i++){
            if(sides[i] > max) max = sides[i];
            tot += sides[i];
        }

        return max >= (tot - max) ? 2 : 1;
    }
}