/*
1. 괄호 회전 -> 해당 괄호쌍의 길이 n 만큼 보는 View가 오른쪽으로 이동
2. 올바른 괄호 -> 닫는 괄호가 있다면 pop 했을때 바로 동일하게 열리는 괄호가 있어야 한다. 
3. 로직 :
    1. 회전이 s 길이-1 만큼 진행했다면(s-1) 부터 (2s-1) 까지를 보고 있는 것과 같다 
    2. 따라서 s의 길이를 두배로 만들어서 복제시킨다. 
    3. 뷰의 왼쪽을 0 ~
*/
import java.io.*;
import java.util.*;
class Solution {
    public int solution(String s) {
        int length = s.length(); //String은 참조형이므로 메서드가 있다. 
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        
        //ArrayDeque<Character> stack = new ArrayDeque<>();
        int answer=0;
        String nS = s + s;
        A :for(int i=0;i<length;i++){ //뷰의 왼쪽 출발점 인덱스 고르기
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(int j=i;j<i+length;j++){ //선택된 뷰를 돌면서 올바른 괄호 판단
                //1. 판단은 닫는 괄호가 한다. 
                //2. 닫는괄호가 아닐때는 (=여는괄호) 스택에 넣는다. 
                char c = nS.charAt(j);
                if(!map.containsKey(c)){
                    stack.push(nS.charAt(j));
                }else{
                
                if(stack.isEmpty() || !stack.pop().equals(map.get(c))){
                    continue A;
                }
                }
            }
            
            if(stack.isEmpty()){
                //여기 까지 왔는데 스택이 비었으면 올바른 문자열이다.
                answer++;
            }
        }
        
        return answer;
    }
}