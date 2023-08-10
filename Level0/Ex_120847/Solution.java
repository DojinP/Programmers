package Ex_120847;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 31, 24, 10, 1, 9}));
    }

    public static int solution(int[] numbers) {
        // 최대값 구하기
        int temp = 0;
        int max1_idx = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] > temp) {
                temp = numbers[i];
                max1_idx = i;
            }
        }

        // 두 번째로 큰 수 구하기
        temp = 0;
        int max2_idx = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] > temp && i != max1_idx) {
                temp = numbers[i];
                max2_idx = i;
            }
        }

        return numbers[max1_idx] * numbers[max2_idx];
    }
}