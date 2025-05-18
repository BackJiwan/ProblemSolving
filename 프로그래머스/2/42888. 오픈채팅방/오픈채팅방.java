/*
1. 들어왔습니다. 나갔습니다를 출력해주는 answer 
2. 아이디 : 닉네임 쌍을 저장하는 uid map 이 있다. 
3. Enter, 또는 Change의 경우에만 uid map에 변동이 생긴다. 
4. Leave의 경우는 출력을 위한 answer map에만 영향을 준다. 
5. 최종 시점에서 기록을 해야하기 때문에 uid map에 모든 작업을 하고 나서 다시 record를 순회해야 한다. 
*/
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        //1. 출력을 위해 Enter : 들어왔습니다. Leave. : 나갔습니다를 저장하는 Map msg
        
        //2. 최종 아이디 : 닉네임 쌍을 저장하는 Map uid
        
        //3. record를 순회하며 명령을 msg가 가지고 있다면 answer리스트에 저장한다. 
        
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter","님이 들어왔습니다.");
        msg.put("Leave","님이 나갔습니다.");
        
        // uid는 Enter 또는 Change인 경우에만 map에 추가되게 된다. 
        HashMap<String, String> uid = new HashMap<>();
        for(String s : record){
            String[] cmd = s.split(" ");
            if(cmd.length == 3){
                //Enter 또는 Change인 경우 길이가 3이다. 
                uid.put(cmd[1],cmd[2]);
            }
        }
        
        
        //
        ArrayList<String> answer = new ArrayList<>();
        for(String s : record){
            String[] cmd = s.split(" ");
            //Enter, Leave인 경우에만 anwwer에 담으면 된다. 
            if(msg.containsKey(cmd[0])){
                answer.add(uid.get(cmd[1])+msg.get(cmd[0]));
            }
        }
        
        return answer.toArray(new String[0]);
        
        
    }
}