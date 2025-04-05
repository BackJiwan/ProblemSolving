import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        //0.삭제된 인덱스 k를 저장할 스택
        Stack<Integer> deleted = new Stack<>();
        
        //1. k=i일때의 위포인터, 아래포인터를 저장 
        //기존 k= 0 ~ (n-1) 까지이지만 이것을 +1로 right shift 한뒤
        //앞뒤로 padding을 1칸씩 둔다. 0,1~n,n+1
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i=1;i<n+1;i++){ //1~n 이므로 실제 인덱스만 i범위로 움직임
            up[i] = i-1;
            down[i] = i+1;
        }
        
        //2.+1 쉬프트 연산을 가정하기 위해서 k++ 연산 수행
        k++;
        
        
        //3.cmd를 하나씩 꺼내서 명령을 확인한다.
        for(String s : cmd){
            if(s.startsWith("C")){
                //3-1. 만약 C라면 현재 행을 삭제하기 위해서 
                //현재행 k 를 deleted에 push하고 
                //삭제된 배열에 k를 추가, 포인터를 조정해서 k를 무시하고 가리키도록 수정
                //C연산이 가장 마지막인 n에서발생한 경우라면 현재포인터가 하나 위를 보도록 조정
                //k갱신 기본값은 down[k]이지만 k가 이미 맨 밑이라면 up[k]를 넣어야한다.
                //down[k]가 n과 같다면 k를 갱신할수 있지만 n보다 크면 up[k]를 넣는다. 
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n<down[k] ? up[k] : down[k];
            }else if(s.startsWith("Z")){
                //3-2. 만약 Z라면 deleted에서 하나 pop해서 삭제이력을 없애고
                //pop해서 살린 인덱스의 위 아래를 정상화시켜서 해당 인덱스를 보도록 해준다.
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }else{
                //3-3. 외에는 U,D 이므로 업 또는 다운의 경우인데 
                //표의 범위를 벗어나는 입력은 주어지지 않기 때문에 
                //명령으로 움직일 칸을 구한뒤에 
                //해당 이동횟수만큼 k = up[k]로 k를 갱신해주면 된다. 
                //다운 이면 k = down[k]로 k를 갱신 
                String[] strArr = s.split(" ");
                int step = Integer.parseInt(strArr[1]);
                
                for(int i=0;i<step;i++){
                    k = strArr[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        //4. 제출을 위해서 원시형 char 배열을 n 크기로 만들고 
        //Arrays.fill을 이용해 기본값 'O'를 채운다. 
        //selected 스택을 하나씩 pop 하면서 해당 인덱스-1 위치를 'X'로 변경
        //new String(char[])를 통해서 스트링으로 반환한다. 
        
        char[] answer = new char[n]; //여기부터는 다시 원래대로 0 ~ (n-1) 까지 쓴다
        Arrays.fill(answer,'O');
        
        while(!deleted.isEmpty()){
            int del = deleted.pop();
            answer[del-1] = 'X';
        }
        
        return new String(answer);
        
    }
}