//k의 개수

package Ex_120887;

// import java.util.Arrays;
// import java.util.stream.IntStream;
// import java.util.stream.Stream;

/*
 * 문제 설명
 * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(1, 13, 1));
        System.out.println(solution(10, 50, 5));
        System.out.println(solution(3, 10, 2));
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;
        for(int n=i; n<=j; n++){
            String target = String.valueOf(n);
            for(int t=0; t<target.length(); t++){
                if(target.charAt(t)-'0' == k) answer++;
            }
        }
        return answer;
    }
    
}

// public static int solution(int i, int j, int k) {
    //     https://www.youtube.com/watch?v=1gXFrh9PBic
        
    //     map vs flatMap 의 차이점 공부
        
    //     IntStream.rangeClosed(i, j).mapToObj(String :: valueOf).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out :: println);
    //     IntStream.rangeClosed(i, j).mapToObj(String :: valueOf).forEach(System.out :: println);
    //     IntStream.rangeClosed(i, j).mapToObj(String :: valueOf).flatMap(str -> Arrays.stream(str.split(""))).forEach(System.out :: println);
    //     return IntStream.rangeClosed(i, j)
    //                     .mapToObj(String :: valueOf)
    //                     .flatMap(str -> Arrays.stream(str.split("")))
    //                     .filter(ch -> ch.equals(String.valueOf(k)))
    //                     .toArray().length;
    // }