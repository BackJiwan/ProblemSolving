import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == stack.peek()) {
                //스택이 비어있지 않고,뽑은c가 stack의 peek과 같다면? pop
                stack.pop();
            }else{
                //스택이  비어있거나, 뽑은c가 stack의 peak과 다르다 -> push
                stack.push(c);
            }
        }
        
        //다 돌고 stack이 안비었으면 제거불가능
        
        answer = (stack.isEmpty()?1:0);
        return answer;
    }
}