// 등차수열, 등비수열의 다음 항 구하기

package Ex_120924;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{2, 4, 8}));
    }

    public static int solution(int[] common) {
        if(common[1] - common[0] != common[2] - common[1]){
            // 등비 수열
            return common[common.length-1] * (common[1] / common[0]);
        }else{
            // 등차 수열
            return common[common.length-1] + (common[1] - common[0]);
        }
    }
}