package Ex_120841;

class Solution {

    public static void main(String[] args) {
        int[] dot = {-3, 2};
        System.out.println(solution(dot));
    }

    public static int solution(int[] dot) {
        if(dot[0] < 0){
            if(dot[1] < 0){
                return 3;
            }else{
                return 2;
            }
        }else{
            if(dot[1] < 0){
                return 4;
            }else{
                return 1;
            }
        }
    }
}