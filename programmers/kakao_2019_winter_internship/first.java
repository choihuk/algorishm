import java.util.*;

class first{
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stack = new Stack[board.length];
        for(int i=0; i<board[0].length; i++) stack[i] = new Stack<>();
        for(int i=board.length-1; i>=0; i--){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]>0){
                    stack[j].push(board[i][j]);
                }
            }
        }
        Stack<Integer> box = new Stack<>();
        for(int i=0; i<moves.length; i++){
            if(!stack[moves[i]-1].empty()){
                int a = stack[moves[i]-1].pop();
                if(box.empty()){
                    box.push(a);
                }else{
                    int b = box.peek();
                    if(a==b){
                        box.pop();
                        answer+=2;
                    }else{
                        box.push(a);
                    }
                }
            }
        }
        return answer;
    }
}