import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //정답기록
        List<Integer> answer = new ArrayList<>();
        
        //n은 작업의 개수
        int n = speeds.length;
        
        //각 작업별 배포남은 날짜를 모두 계산해서 enqueue
        int[] lefts = new int[n];
        
        //배포 남은날 계산하기
        for(int i=0;i<n;i++){
            int temp;
            temp = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            lefts[i] = temp;
        }
        
        //day를 굳이 첫날부터로 할 필요가없음, 맨앞에꺼의 필요날짜부터 시작함 
        int curDay = lefts[0];
        int count = 0;
        
        for(int i=0;i<n;i++){
            //배포 남은날 배열을 전부 돌거임 ,i가 인덱스임 
            // 어차피 앞에서부터 돌꺼니까 배포 우선순위도 지켜짐 
            //curDay를 굳이 첫날부터로 할 필요가없음, 맨앞에꺼의 필요날짜부터 시작함 
            if(lefts[i] <= curDay){
                //배포남은날 배열을 0 ~ n-1 까지 열어보는데 curDay보다 같거나 작다면 count++ 
                count++;
            }else{
                //배포를 못하게되는 상황이오면 이때에 answer에 add 하고 count를 1로 초기화한다. 
                //그리고 curDay도 증가시킨다. 
                answer.add(count);
                count = 1;
                //**1차시도 실패요인** : curDay를 단지 ++ 해버리면 for반복문은 left를 하나씩 건너 뛰기 때문에 앞으로 필요한 배포일이 많이 남은 경우라면
                //여기서 단지 1만 증가시켜버리면 실제로 배포까지 필요한 curDay가 유의미하게 증가되지 않았음에도 지속적으로 밙복문이 i를 증가시켜서
                //우리의 lefts를 계속 뛰어 넘어버리게 된다. 
                //따라서 배포를 못하게 되는 상황이 왔으면 이제 실제로 lefts의 다음 요소가 필요한 Day로 한번에 맞춰주면 될일이다. 
                //curDay++; -> 요거 이렇게 하면 안되는 거임 
                curDay = lefts[i];
            }
        }
        
        //answer에 add 되는 트리거는 else에 걸렸을때에만 저장된다. 
        //가장 마지막 경우라면 curDay가 충분히 크고, lefts[i]는 마지막까지 충분히 작아서 count++ 연산만 지속하다가 add 하지 않고 반복문을 나오게 된다. 
        //따라서 마지막 남은 count를 answer에 add 해주는 작업이 필요하다
        answer.add(count);
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}