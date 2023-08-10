public class Solution{
    public static void main(String[] args) {
        int result = solution(new String[] {"aya", "yee", "u", "maa", "wyeoo"});

        System.out.println(result);
    }

    public static int solution(String[] babbling) {
        String[] babble = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<babble.length; j++){
                babbling[i] = babbling[i].replace(babble[j], " ");
            }
        }

        for(int i=0; i<babbling.length; i++){
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i].equals("")){
                answer++;
            }
        }

        return answer;
    }
}
