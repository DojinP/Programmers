import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
                ))); // [2, 1, 1, 0]
    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        HashSet<String> reportSet = new HashSet<>();
        boolean[][] reportResult = new boolean[id_list.length][id_list.length];
        int[] reported_count = new int[id_list.length];
        int[] mail_count = new int[id_list.length];

        // Set에 저장하여 중복 제거
        for(int i=0; i<report.length; i++){
            reportSet.add(report[i]);
        }

        // 신고된 횟수 업데이트
        for(String str : reportSet){
            String[] temp = str.split(" ");

            for(int i=0; i<id_list.length; i++){
                if(id_list[i].equals(temp[1])) {
                    reported_count[i]++;
                    break;
                }
            }
        }

        // 신고된 횟수가 k 회 이상인 유저를 신고한 유저의 mail_count 업데이트
        for(int i=0; i<reported_count.length; i++){
            if(reported_count[i] >= k){
                String target_user = id_list[i];

                for(String str : reportSet){
                    String[] temp = str.split(" ");
                    // 신고된 유저가 k 회 이상 신고된 유저인 경우
                    if(temp[1].equals(target_user)) {
                        // 신고한 유저를 탐색
                        for(int j=0; j<id_list.length; j++) {
                            // 신고한 유저에게 메일 한 통
                            if(id_list[j].equals(temp[0])) {
                                mail_count[j]++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return mail_count;
    }

}
