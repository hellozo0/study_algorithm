import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char alphabet = s.charAt(i);
            
            if(stack.isEmpty()) {
                stack.push(alphabet);
            } else {
                if(stack.peek() == alphabet) {
                    stack.pop();
                } else {
                    stack.push(alphabet);
                }
            }
        }
        
        if( stack.isEmpty()) answer = 1;
        else answer = 0; 
        

        return answer;
    }
}