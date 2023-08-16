// 등수 매기기
package Ex_120882;

import java.util.*;
import java.util.stream.*;

/*
 * 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 
 * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {90, 50}, {40, 70}, {50, 80}})));
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {70, 80}, {50, 100}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
        System.out.println(Arrays.toString(solution(new int[][] {{0, 20}, {80, 100}, {10, 10}, {90, 90}, {20, 0}})));
    }

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] average = new double[score.length];

        for(int i=0; i<score.length; i++){
            average[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        double[] sorted_average = sortAndDeduplication(average);

        // 순위 매기기
        int rank = 1;
        for(int i=0; i<sorted_average.length; i++){
            int count = 0;
            for(int j=0; j<average.length; j++){
                if(average[j] == sorted_average[i]) {
                    answer[j] = rank;
                    count++;
                }
            }
            rank += count;
        }

        return answer;
    }

    public static double[] sortAndDeduplication(double[] origin_arr){
        System.out.println("before: " + Arrays.toString(origin_arr));

        double[] arr = origin_arr.clone();

        // sort
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // deduplication
        List<Double> li = Arrays.stream(arr).distinct().boxed().collect(Collectors.toList());
        System.out.println("after: " + li);

        return li.stream().mapToDouble(i->i).toArray();
    }
}