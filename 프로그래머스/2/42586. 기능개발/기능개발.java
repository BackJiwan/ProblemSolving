import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = {};
        // return answer;
        
        //정답을 관리하기 위한 큐 
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length; 
        
        //남은 날짜를 모두 올림하여 미리 저장해두기 
        int[] leftDays = new int[n];
        for(int i=0;i<n;i++){
            int tmp;
            tmp = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            leftDays[i] = tmp; //이게 없어서 1차 시도 틀렸었음..
        }
        
        //최초 값부터 보기 시작해서 만약 같거나 작으면 count++
        //그게 아니라면 conut를 answer에 add 하고 
        //count를 1로 초기화 하고 다시 반복문
        int count = 0;
        int maxDay = leftDays[0];
        for(int i=0;i<n;i++){
            if(leftDays[i]<=maxDay){ //앞선 배포일보다 작거나 같으니까 배포가능하다
                count++;
                
            }else{
                //배포못하는거니까 여기서 answer에 add 하고 count 를 1로 초기화
                answer.add(count);
                count = 1;
                maxDay = leftDays[i];
            }
        }
        
        //가장 마지막에 add 된 요소는 else 걸리기전에 반복문을 나왔으므로 answer에 안들어갔다.
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}