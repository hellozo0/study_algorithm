//https://school.programmers.co.kr/learn/courses/30/lessons/49994
import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        HashSet<String> set = new HashSet<>();
        
        int nowX = 0;
        int nowY = 0;
        for(int i = 0; i < dirs.length(); i++){
            String s = "";
            int nextX = nowX;
            int nextY = nowY;
            char direction = dirs.charAt(i);
            
            if(direction == 'L'){
                nextX--;
                s = nowX+""+nowY+" "+nextX+""+nextY; //00 -> -10
            } else if(direction == 'R'){
                nextX++;
                s = nextX+""+nextY+" "+nowX+""+nowY;
            } else if(direction == 'U'){
                nextY++;
                s = nowX+""+nowY+" "+nextX+""+nextY;
            } else if (direction == 'D'){ //D
                nextY--;
                s = nextX+""+nextY+ " " + nowX+""+nowY;
            }
            
            if(nextX < -5 ||nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }
            set.add(s);
            nowX = nextX;
            nowY = nextY;
        }        
        return set.size();
 
    }
}
