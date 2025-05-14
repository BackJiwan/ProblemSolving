import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // String answer = "";
        // return answer;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : participant){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        for(String c : completion){
            map.put(c,map.get(c)-1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){
                return entry.getKey();
            }
        }
        return null;
        
    }
}