package Ex_120894;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("onetwothreefourfivesixseveneightnine"));
        System.out.println(solution("onefourzerosixseven"));
    }

    public static long solution(String numbers) {
        String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for(int i=0; i<words.length; i++){
            numbers = numbers.replaceAll(words[i], String.valueOf(i));
        }

        long answer = Long.parseLong(numbers);

        return answer;
    }
}