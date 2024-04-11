import java.lang.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            
            if(letter == '('){
                stack.push('(');
            } 
            else {
                if( stack.size() == 0){
                    return false;
                }
                
                stack.pop();
            }
        }
        
        if(stack.size() == 0){
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}