import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer>[] lanes = new Stack[board.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<board[0].length;i++){
            lanes[i] = new Stack<>();
        }
        
        for(int i=board.length-1;i>=0;i--){
            for(int j=0;j<lanes.length;j++){
                if(board[i][j] > 0){
                    lanes[j].push(board[i][j]);
                }
            }
        }
        
        for(int i=0;i<moves.length;i++){
            int selected = moves[i];
            // lanes[selected]에서
            // 뽑은뒤 행동(만약 비어있으면 그냥 스킵 먼저하면 될듯?)
            //1. stack이 비어 있으면 그냥 push 하면된다.
            //2. stack이 차있지만, 지금과 다르면 push 하면된다. 
            //3. stack이 차있지만 , 지금과 같으면 스택을 pop 하고 answer += 2;
            // 그러니까 lanes가 not EMpty인 경우에만 들어온다. 
            if(!lanes[selected-1].isEmpty()){
                //해당하는 레인에 요소가 1개 이상 있다. 
                int doll = lanes[selected-1].pop();
                if(!stack.isEmpty() && stack.peek() == doll){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(doll);
                }
            }
        }
        
        return answer;
    }
}