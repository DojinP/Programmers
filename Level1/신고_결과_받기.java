import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(
//                new String[] {"muzi", "frodo", "apeach", "neo"},
//                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
//                2
//                ))); // [2, 1, 1, 0]

        System.out.println(Arrays.toString(solution(
                new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
                3
        ))); // [0, 0]
    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        boolean[][] reportResult = new boolean[id_list.length][id_list.length];
        int[] reported_count = new int[id_list.length];
        int[] mail_count = new int[id_list.length];
        StringTokenizer st;

        // report 체크, 신고된 횟수 업데이트
        for(int i=0; i<report.length; i++){
            st = new StringTokenizer(report[i]);
            String reporter = st.nextToken();
            String villain = st.nextToken();

            int reporter_idx = 0;
            int villain_idx = 0;

            for(int j=0; j<id_list.length; j++) {
                if(reporter.equals(id_list[j])) {
                    reporter_idx = j;
                }else if(villain.equals((id_list[j]))) {
                    villain_idx = j;
                }
            }

            if(!reportResult[reporter_idx][villain_idx]) reported_count[villain_idx]++;

            reportResult[reporter_idx][villain_idx] = true;

        }

        // 신고된 횟수가 k 회 이상인 유저를 신고한 유저의 mail_count 업데이트
        for(int i=0; i<reported_count.length; i++){
            if(reported_count[i] >= k){
                for(int j=0; j<id_list.length; j++){
                    if(reportResult[j][i]) mail_count[j]++;
                }
            }
        }

        return mail_count;
    }

}
