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

//MAP 쓸때 
/*
통과 (22.08ms, 80.7MB)
테스트 2 〉	통과 (7.54ms, 84MB)
테스트 3 〉	통과 (9.46ms, 77.5MB)
테스트 4 〉	통과 (15.23ms, 80.7MB)
테스트 5 〉	통과 (35.29ms, 79.7MB)
테스트 6 〉	통과 (11.24ms, 83.6MB)
테스트 7 〉	통과 (28.33ms, 81.2MB)
테스트 8 〉	통과 (22.73ms, 78.9MB)
테스트 9 〉	통과 (48.82ms, 80.4MB)
테스트 10 〉	통과 (54.34ms, 70.3MB)
테스트 11 〉	통과 (56.14ms, 86.4MB)
테스트 12 〉	통과 (0.19ms, 73.8MB)
테스트 13 〉	통과 (0.20ms, 72.3MB)
테스트 14 〉	통과 (0.19ms, 75.2MB)
*/

//if-else 쓸 때 
/*
통과 (17.89ms, 68.2MB)
테스트 2 〉	통과 (8.17ms, 84.2MB)
테스트 3 〉	통과 (9.95ms, 74MB)
테스트 4 〉	통과 (11.61ms, 79.3MB)
테스트 5 〉	통과 (26.77ms, 84.8MB)
테스트 6 〉	통과 (16.58ms, 80.6MB)
테스트 7 〉	통과 (21.13ms, 81.2MB)
테스트 8 〉	통과 (23.15ms, 86.3MB)
테스트 9 〉	통과 (48.35ms, 92.2MB)
테스트 10 〉	통과 (59.60ms, 78.5MB)
테스트 11 〉	통과 (54.06ms, 79.6MB)
테스트 12 〉	통과 (0.20ms, 74.9MB)
테스트 13 〉	통과 (0.27ms, 76.3MB)
테스트 14 〉	통과 (0.18ms, 73.1MB)
*/