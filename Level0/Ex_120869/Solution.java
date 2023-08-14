// 외계어 사전
package Ex_120869;

/*
 * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 
 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. 
 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"p", "o", "s"}, new String[] {"sod", "eocd", "qixm", "adio", "soo"}));
        System.out.println(solution(new String[] {"z", "d", "x"}, new String[] {"def", "dww", "dzx", "loveaw"}));
        System.out.println(solution(new String[] {"s", "o", "m", "d"}, new String[] {"moos", "dzx", "smm", "sunmmo", "som"}));
    }

    public static int solution(String[] spell, String[] dic) {
        String target = "";
        int answer = 0;
        for(int i=0; i<dic.length; i++){
            for(int j=0; j<spell.length; j++){
                dic[i] = dic[i].replaceFirst(spell[j], "-");
                target += "-";
            }
            if(dic[i].equals(target)) answer++;
            target = "";
        }

        return answer > 0 ? 1 : 2;
    }
}