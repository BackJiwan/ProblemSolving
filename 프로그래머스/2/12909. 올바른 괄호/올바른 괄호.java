import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
    
        char[] array = s.toCharArray();
        
        for(char c: array){
            if(c=='('){
                stack.push(c);
            }else{ //닫는괄호가 나온경우
                if(stack.isEmpty() || stack.pop() == '('){
                    return false;
                }
            }
        }
			return true;
    }
}