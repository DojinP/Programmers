// 종이 자르기
package Ex_120922;

/*
 * 머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다. 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }

    public static int solution(int M, int N) {
        // m x n 의 종이
        // (m-1) + m(n-1)
        return (M-1) + M * (N-1);
    }
}