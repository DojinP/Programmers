package Ex_120818;

public class Solution {
    public int solution(int price) {
        double discount_rate = 1.0;
        if(price >= 500000){
            discount_rate = 0.8;
        }else if(price >= 300000){
            discount_rate = 0.9;
        }else if(price >= 100000){
            discount_rate = 0.95;
        }
        
        return (int)(price * discount_rate);
    }
}
