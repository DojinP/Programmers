// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
package Level2.Ex_42839;


import java.util.ArrayList;
import java.util.Arrays;

//
public class Solution {
    public static ArrayList<Integer> primeList = new ArrayList<>();
//    public static int count = 0;

    public static void main(String[] args) {
//        System.out.println(solution("011"));
//        System.out.println(solution("17"));
        System.out.println(solution("143"));
    }

    public static int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        char[] chars = new char[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            chars[i] = numbers.charAt(i);
        }

        int count = 0;
        for(int i=0; i<numbers.length(); i++){
            count += dfs(i, visited, chars, "");
            //Arrays.fill(visited, false);
        }

        System.out.println(primeList);

        return count;
    }

    public static int dfs(int idx, boolean[] visited, char[] chars, String target){
//        if(idx == chars.length) return 0;
        boolean[] cloned_visited = visited.clone();
        idx %= cloned_visited.length;

        cloned_visited[idx] = true;
        target += chars[idx];

        int count = 0;
        int targetNum = Integer.parseInt(target);
        if(isPrime(targetNum) && !primeList.contains(targetNum)) {
            count++;
            primeList.add(targetNum);
        }

        for(int i=idx+1; i<=idx+cloned_visited.length; i++){
            if(cloned_visited[i%visited.length] == false) {
                count += dfs(i, cloned_visited, chars, target);
//                break;
            }
        }

        return count;
    }

    public static boolean isPrime(int target){
        System.out.println("target : " + target);
        if(target < 2) return false;
        for(int i=2; i<=target/2; i++) {
            if(target % i == 0) return false;
        }
        return true;
    }

}
