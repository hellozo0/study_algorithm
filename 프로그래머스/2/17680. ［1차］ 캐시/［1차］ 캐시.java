// 0 ≦ cacheSize ≦ 30 
//cities는 100,000개 가 맥시멈이다. 

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
    
        ArrayList<String> list = new ArrayList<>();
        
        if(cacheSize == 0) return (5 * cities.length);
        

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if(list.contains(city)) {
                answer++;
                list.remove(city); //해당 객체 를 삭제
                list.add(city); // 해당 객체를 맨 뒤에 삽입
            } else {
                if(list.size() == cacheSize) {
                    list.remove(0);
                }
                answer += 5;
                list.add(city);  
            }
        }
        
        
        return answer;
    }
}