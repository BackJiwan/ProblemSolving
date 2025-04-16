import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // return answer;
        
        HashSet<String> set = new HashSet<>(Arrays.asList(participant));
        
        for(String s : completion){
            if(set.contains(s)){
                continue;
            }else{
                answer = s;
            }
        }
        
        //System.out.println(set.toString());
        return answer;
    }
}