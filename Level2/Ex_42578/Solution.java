// 의상
// https://school.programmers.co.kr/learn/courses/30/lessons/42578
package Level2.Ex_42578;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> fashion = new HashMap();

        for(String[] cloth : clothes){
            if(!fashion.containsKey(cloth[1])) {
                fashion.put(cloth[1], new ArrayList<String>());
                fashion.get(cloth[1]).add(cloth[0]);
            }
            else
                fashion.get(cloth[1]).add(cloth[0]);
        }

        int answer = 1;

        for(String key : fashion.keySet()){
            answer *= fashion.get(key).size()+1;
        }

        return answer-1;
    }
}