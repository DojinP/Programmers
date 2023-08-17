// 특이한 정렬
package Ex_120880;

import java.util.Arrays;

/*
 * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 
 * 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5, 6}, 4)));
        System.out.println(Arrays.toString(solution(new int[] {10000,20,36,47,40,6,10,7000}, 30)));
    }

    public static int[] solution(int[] numlist, int n) {
        int[] answer = mySort(numlist, n);

        return answer;
    }

    public static int[] mySort(int[] arr, int n){
        int[] retArr = arr.clone();
        
        // 기준 값 빼기
        for(int i=0; i<retArr.length; i++){
            retArr[i] -= n;
        }

        // 2차 정렬을 위한 오름차순 정렬
        for(int i=0; i<retArr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(retArr[i] > retArr[j]){
                    int temp = retArr[i];
                    retArr[i] = retArr[j];
                    retArr[j] = temp;
                }
            }
        }

        System.out.println("1차 정렬 : " + Arrays.toString(retArr));

        // 절대값이 낮은 순으로 2차 정렬 (절대값이 큰 값을 배열의 끝으로)
        for(int i=0; i<retArr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(Math.abs(retArr[i]) >= Math.abs(retArr[j])){
                    int temp = retArr[i];
                    retArr[i] = retArr[j];
                    retArr[j] = temp;
                }
            }
        }

        // 기준 값 더하기
        for(int i=0; i<retArr.length; i++){
            retArr[i] += n;
        }

        return retArr;
    }
}