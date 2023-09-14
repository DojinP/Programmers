// https://school.programmers.co.kr/learn/courses/30/lessons/43164
package Level3.Ex_43164;

import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {
    static boolean[] visited;
//    static String[] answers;
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        // "ICN", "ATL", "ICN", "SFO", "ATL", "SFO"
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        String[] answers = new String[tickets.length+1];

        visited = new boolean[tickets.length];

        // 알파벳 순으로 정렬
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        for(int i=0; i<tickets.length; i++) {
            // ICN 공항으로부터 출발
            if(tickets[i][0].equals("ICN")) {
                // i번 요소 방문
                visited[i] = true;
                answers[0] = tickets[i][0];

                // dfs 시작
                dfs(1, tickets[i][1], tickets, answers);

                // 재귀 종료 시 answers 의 마지막 원소가 ""가 아니라면 모든 경로를 방문한 것으로 판단
                if (answers[answers.length - 1] != null) return answers;

                // i번 요소 방문 취소
                answers[0] = null;
                visited[i] = false;
            }
        }

        return answers;
    }
    // idx - answers 배열의 index
    // count - 선택한 tickets 배열 원소의 수
    // target - 다음에 선택해야할 출발지의 이름
    // answers - 선택한 노드를 저장하는 배열
    public static void dfs(int idx, String target, String[][] tickets, String[] answers) {
        // idx 가 tickets.length 가 되면 재귀 종료.
        if(idx == tickets.length) {
            // 마지막 타깃을 answers 에 추가
            answers[idx] = target;
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            // 선택한 적이 없으며, ticket 의 출발지가 target 과 동일한 ticket 을 탐색
            if(!visited[i] && tickets[i][0].equals(target)) {
                visited[i] = true;
                answers[idx] = tickets[i][0];

                dfs(idx+1, tickets[i][1], tickets, answers);

                if(answers[idx+1] != null)
                    return;

                visited[i] = false;
                answers[idx] = null;
            }
        }
    }
}
