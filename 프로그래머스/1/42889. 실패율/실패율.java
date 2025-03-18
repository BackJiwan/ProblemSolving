import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //1. 스테이지별 도전 중인 인원 구하기(배열)
        //stages의 도전중인 스테이지 번호를 사용
        int people = stages.length; //도전중인 사용자의수 
        int[] challengers = new int[N+2]; //각 단계별 도전자의 수 1 ~ N+1 까지 사용한다. 
        //stages의 길이만큼 반복 
        //이제 challengers[i]에는 i 단계에 도전중인 사람의 수가 있다. 
        for(int i=0;i<people;i++){
            challengers[stages[i]] += 1;
        }
        
        //2. 각 스테이지 별로 실패율 구하기
        //2-1. 스테이지,실패율 <Integer,Double> Key - Value 쌍
        HashMap<Integer,Double> fails = new HashMap<>();
        double total = people;
        
        //2-2. challengers를 1부터 N+1 까지 탐색하며 각 단계별로 현재인원/total으로 실패율
        //을 저장한다. 저장하고 난 뒤에는 해당 단계의 인원을 total에서 제거해준다. 
        
        for(int i=1;i<=N;i++){
            if(challengers[i]==0){
                fails.put(i,0.0);
            }else{fails.put(i,challengers[i] / total);
            total -= challengers[i];}
            
            
        }
        
        //HashMap<Integer,Double> -> int[]
        //HashMap<Integer,Double> -> Entry<Map<Integer,Double>> = enrtySet()
        //Entry<Map<Integer,Double>> -> Stream<Map<Integer,Double>> = stream();
        //Stream<Map<Integer,Double>> -> 내림차순 정렬 , 정렬기준은 Value를 사용 
        // = sorted((o1,o2)->Double.compare(o2.getValue(),o1.getValue()))
        //Stream<Map<Integer,Double>> -> IntStream()
        //=여전히 정렬된 Entry<Map> 이므로 EntryMap 클래스의 getKey를 메서드 참조
        //=메서드 호출이 아닌 메서드 참조 이므로 getKey()가 아닌 getKey이다. 
        //Map에서는 key 또는 value 중에 골라서 연산하기 때문에 getKey와 mapToInt이다.
        //IntStream() -> int[] 
        
        return fails.entrySet().stream()
            .sorted((o1,o2) -> Double.compare(o2.getValue(),o1.getValue()))
            .mapToInt(Map.Entry::getKey).toArray();
    }
}