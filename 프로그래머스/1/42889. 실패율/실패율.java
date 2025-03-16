import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //int[] answer = {};
        
        //1.각 단계별 도전자의 수 배열 계산하기 
        int[] challengers = new int[N+2];
        for(int i=0;i<stages.length;i++){
            challengers[stages[i]] += 1;
        }
        //2. 실패율을 담을 자료구조 준비 
        HashMap<Integer,Double> fails = new HashMap<>();
        double total = stages.length;
        //3. 단계별 도전자수 배열을 돌며 실패율 기록
        for(int i=1;i<=N;i++){
            if(challengers[i]==0){
                fails.put(i,0.0);
            }else{
                fails.put(i,challengers[i]/total);
                total -= challengers[i];
            }
        }
        //4. 실패율이 높은 스테이지부터 내림차순으로 정렬 및 배열로 리턴
        
        return fails.entrySet().stream()
            .sorted((o1,o2)->Double.compare(o2.getValue(),o1.getValue()))
            .mapToInt(HashMap.Entry::getKey).toArray();
    }
}