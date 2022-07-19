import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();   //바구니
        int mSize = board[0].length;    //맵 사이즈
        int answer = 0;

        for(int mv : moves) {
            int cr = -1;    //크레인에 걸린 인형
            int top = -100; //바구니의 가장 위에 있는 인형

            for(int i = 0; i < mSize; i++) {
                if(board[i][mv-1] == 0) {
                    continue;
                }
                else {
                    cr = board[i][mv-1];    //크레인이 인형 집음
                    board[i][mv-1] = 0;     //맵에서 인형 삭제
                    if(!s.isEmpty()) {
                        top = s.peek();
                    }
                    s.push(cr);
                    break;
                }
            }
            if(top == cr ) {
                s.pop();
                s.pop();    //바구니의 인형 두 개 삭제
                answer = answer + 2;
            }
        }


        return answer;
    }
}