package Ex_120903;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"a", "b", "c"}, new String[] {"com", "b", "d", "p", "c"}));
        System.out.println(solution(new String[] {"n", "omg"}, new String[] {"m", "dot"}));
    }

    public static int solution(String[] s1, String[] s2) {
        int count = 0;

        for(int i=0; i<s1.length; i++){
            for(int j=0; j<s2.length; j++){
                if(s1[i].equals(s2[j])) count++;
            }
        }

        return count;
    }
}