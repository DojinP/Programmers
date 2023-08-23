// 베스트 앨범
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
package Level3.Ex_42579;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> playMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            int play = plays[i];
            if(!genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], play);
                playMap.put(genres[i], new HashMap<>());
                playMap.get(genres[i]).put(i, play);
            }else{
                genreMap.compute(genres[i], (s, integer) -> integer + play);
                playMap.get(genres[i]).put(i, play);
            }
        }

        List<Map.Entry<String, Integer>> entries = genreMap.entrySet().stream()
                                                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                                                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entries){
            List<Map.Entry<Integer, Integer>> playEntries = playMap.get(entry.getKey()).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .collect(Collectors.toList());
            resultList.add(playEntries.get(0).getKey());
            if(playEntries.size() >= 2)
                resultList.add(playEntries.get(1).getKey());
        }

//        System.out.println(resultList);
//        System.out.println(entries);
//        System.out.println(genreMap);
//        System.out.println(playMap);

        int[] answer = resultList.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}