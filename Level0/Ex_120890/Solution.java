// 가까운 수
package Ex_120890;

// import java.util.Arrays;
// import java.util.stream.Collectors;

/*
 * 문제 설명
 * 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 10, 28}, 20));
        System.out.println(solution(new int[] {10, 11, 12}, 11));
    }

    public static int solution(int[] array, int n) {
        int[] gapArr = new int[array.length];

        for(int i=0; i<array.length; i++){
             gapArr[i] = Math.abs(array[i] - n);
        }

        int minIdx = 0;
        for(int i=1; i<array.length; i++){
            if(gapArr[minIdx] > gapArr[i]){
                minIdx = i;
            }else if(gapArr[minIdx] == gapArr[i]){
                if(array[minIdx] > array[i]){
                    minIdx = i;
                }
            }
        }

        return array[minIdx];
        // return Math.min(array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))], 
        //     array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))]);
    }
}