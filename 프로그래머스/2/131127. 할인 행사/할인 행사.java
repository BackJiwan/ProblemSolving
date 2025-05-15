import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        //wnat,number를 map 으로 변환
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for(int i=0;i<number.length;i++){
            wantMap.put(want[i],number[i]);
        }
        
        int answer = 0;
        
        //discount 변수를 i~ discount.length - 9 까지 시작 가능 날짜를 잡는다. 
        for(int i=0;i<discount.length -9 ;i++){
            //10d map은 10일간의 할인 품목, 개수 맵이다. 
            HashMap<String,Integer> wantMap10d = new HashMap<>();
            
            for(int j=i;j<i+10;j++){
                if(wantMap.containsKey(discount[j])){
                    wantMap10d.put(discount[j],wantMap10d.getOrDefault(discount[j],0)+1);
                }
            }
            
            if(wantMap.equals(wantMap10d)){
                answer++;
            }
        }
        return answer;
    }
}