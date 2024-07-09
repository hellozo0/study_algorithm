import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){ //개수 추가
                map.replace(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }   
        
        for(int i : map.values()){
            answer = answer * (i+1);
        }
        
        return answer-1;
    }
}