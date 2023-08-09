package Ex_120843;

class Solution {

    public static void main(String[] args) {
        int result = solution(new int[] {1, 2, 3, 4, 5, 6}, 5);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int k) {
        // 1번 부터 던진다
        int answer = 1;
        int length = numbers.length;

        // k-1 번 반복 (마지막으로 던진 사람을 고르는 것)
        for(int i=1; i<k; i++){
            answer += 2;
            if(answer > length) answer %= length;
        }

        return answer;
    }
}