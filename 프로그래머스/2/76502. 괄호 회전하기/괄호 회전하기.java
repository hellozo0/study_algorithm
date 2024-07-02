import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        
        // Map<Character, Character> map = new HashMap<>();
        // map.put(')', '(');
        // map.put(']', '[');
        // map.put('}', '{');
        
        for(int i = 0; i < s.length(); i++){ 
            
            flag = true;
            for(int j = 0; j < s.length(); j++){ 
                int index = (i + j) % s.length(); 
                Character letter = s.charAt(index);
                
                if(letter == '(' || letter == '{' || letter == '['){
                    stack.push(letter);
                } else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    } 
                    
                    if(stack.peek() == '(' && letter == ')') {
                        stack.pop();
                    } else if(stack.peek() == '{' && letter == '}') {
                        stack.pop();
                    } else if(stack.peek() == '[' && letter == ']') {
                        stack.pop();
                    } else {
                        flag = false; 
                        break;
                    }
                    
                    // if(map.get(letter) == stack.peek()) {
                    //     stack.pop();
                    // } else {
                    //     flag = false;
                    //     break;
                    // }
                }
            }
            
            if(flag && stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}