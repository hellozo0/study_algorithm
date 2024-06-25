import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Map<Integer,String> map = new HashMap<>();
        int turn = 0;
        
        while(turn < words.length){ 
            answer[0] = (turn % n) + 1;
            answer[1] = (turn / n) + 1;
            
            //단어 1글자 일때 
            if(words[turn].length() == 1) {
                break;
            }
            
            //이전글자랑 끝이랑 이어지지 않을때
            if(turn != 0 && words[turn-1].charAt(words[turn-1].length()-1) != words[turn].charAt(0)) {
                break;
            }
            
            
            //이미 나온 글자 일때
            if(map.containsValue(words[turn])) {
                break;
            } else {
                map.put(turn, words[turn]);
            }
            
            turn++;
        }
        
        if (turn == words.length) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}