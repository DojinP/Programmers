// 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

package Level1.Ex_42576;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        // System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[] {"mislav", "stanko", "stanko", "stanko", "mislav", "mislav", "ana"}, new String[] {"mislav", "stanko", "stanko", "ana", "mislav", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<String, Integer>();

        for(int i=0; i<participant.length; i++){
            if(partMap.get(participant[i]) != null){
                partMap.compute(participant[i], (s, integer) -> integer+1);
            }else{
                partMap.put(participant[i], 1);
            }
        }

        for(int i=0; i<completion.length; i++){
            if(partMap.get(completion[i]) < 2) continue;
            else {
                
            }

            
        }
        
        return "";
    }
}
