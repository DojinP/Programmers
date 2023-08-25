package Level2.Ex_42584;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,2,3,1,5})));
    }

    static int[] solution(int[] prices) {
        int idx = prices.length - 1;
        int count = 0;
        int[] answer = new int[prices.length];

        Stack<Stock> stock = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            if(!stock.isEmpty()){
                while(stock.peek().price > prices[i]){
                    Stock target = stock.pop();
                    answer[target.index] = i - target.index;
                    System.out.println(target.index+1 + "번 요소 : " + answer[target.index]);
                    if(stock.isEmpty()) break;
                }
            }
            stock.push(new Stock(i, prices[i]));
        }

        // 지금 stack 내에는 끝까지 감소하지 않은 값들만 남았다
        while(!stock.isEmpty()){
            Stock target = stock.pop();
            answer[target.index] = prices.length - 1 - target.index; // 현재 index (전체길이 - 1) - 해당 시기의 index = 가격이 감소하지 않은 시간(초)
        }

        return answer;
    }

    public static class Stock {
        int index;
        int price;

        Stock(int index, int price){
            this.index = index;
            this.price = price;
        }
    }
}
