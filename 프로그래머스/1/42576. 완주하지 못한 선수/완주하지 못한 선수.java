import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //map 선수,완주횟수 
        HashMap<String,Integer> map = new HashMap<>();   
        //완주한 선수들을 모두 map에 등록
        for(String s:completion){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(String s : participant){
            if(map.getOrDefault(s,0)==0){
                //참가선수들을 하나씩 빼서 value를 -1 씩하다가 value가 0을 만나면 
                //완주하지 않았고, 참가만한 선수를 detect
                //동명이인 2명중 1명만 완주한 경우 2번째로 참가선수를 꺼냈을 경우에 detect
                return s;
            }else{
                map.put(s,map.getOrDefault(s,0)-1);
            }
        }
        return null;
    }
}