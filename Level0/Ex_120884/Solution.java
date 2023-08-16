// 치킨 쿠폰
package Ex_120884;

/*
 * 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다. 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다. 
 * 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(1081));
        System.out.println(solution(1999));
    }

    public static int solution(int chicken) {
        int answer = 0;
        int coupon = 0;

        while(chicken != 0){
            answer += chicken / 10;
            coupon += chicken % 10;
            if(coupon >= 10) {
                int added_chicken = coupon / 10;
                answer += added_chicken;
                coupon %= 10;
                // 쿠폰으로 시킨 치킨만큼의 쿠폰 추가
                coupon += added_chicken;
            }
            chicken /= 10;
        }
        
        return answer;
    }
}