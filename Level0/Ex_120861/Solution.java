// 캐릭터의 좌표
package Ex_120861;

import java.util.Arrays;

/*
 * 머쓱이는 RPG게임을 하고 있습니다. 
 * 게임에는 up, down, left, right 방향키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다. 
 * 예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1], down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다. 
 * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다. 
 * 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return하도록 solution 함수를 완성해주세요.
 * 
 * [0, 0]은 board의 정 중앙에 위치합니다. 예를 들어 board의 가로 크기가 9라면 캐릭터는 왼쪽으로 최대 [-4, 0]까지 오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.
 */

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"left", "right", "up", "right", "right"}, new int[] {11, 11})));
        System.out.println(Arrays.toString(solution(new String[] {"down", "down", "down", "down", "down"}, new int[] {7, 9})));
    }

    public static int[] solution(String[] keyinput, int[] board) {
        // up, down, left, right
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[] answer = {0, 0};

        for(int i=0; i<keyinput.length; i++){
            switch(keyinput[i]){
                case "up": 
                    if(answer[1] < board[1]/2){
                        answer[0] += dx[0];
                        answer[1] += dy[0];
                    }
                    break;
                case "down":
                    if(answer[1] > -board[1]/2){
                        answer[0] += dx[1];
                        answer[1] += dy[1];
                    }
                    break;
                case "left":
                    if(answer[0] > -board[0]/2){
                        answer[0] += dx[2];
                        answer[1] += dy[2];
                    }
                    break;
                case "right":
                    if(answer[0] < board[0]/2){
                        answer[0] += dx[3];
                        answer[1] += dy[3];
                    }
                    break;
            }
        }

        return answer;
    }
}