// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// DFS 풀이 사용
package Level3.Ex_43163;

public class 단어_변환 {
    static int result = 0;

    public static void main(String[] args) {
//        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hot", "lot", new String[] {"hot", "dot", "dog", "lot", "log"}));
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int count = 0;

        dfs(begin, target, words, visited, count);

        return result;
    }

    public static void dfs(String now, String target, String[] words, boolean[] visited, int count){
        System.out.println(now + " 방문! count = " + count);
        if(now.equals(target)) {
            result = count;
            return;
        }

        for(int i=0; i<now.length(); i++){

            String now_temp = now.substring(0, i) + now.substring(i+1, now.length());

            for(int j=0; j<words.length; j++){
                if(now.equals(words[j])) {
                    visited[j] = true;
                    continue; // now 와 동일한 곳으로 방문하지 않기
                }

                String words_temp = words[j].substring(0, i) + words[j].substring(i+1, words[j].length());

                if(words_temp.equals(now_temp) && !visited[j]){
                    visited[j] = true;
                    dfs(words[j], target, words, visited, count+1);
                    visited[j] = false;
                }

            }

        }

    }
}
