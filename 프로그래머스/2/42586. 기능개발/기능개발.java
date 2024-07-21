import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] day = new int[speeds.length];
        
        for(int i = 0; i < speeds.length; i++){
            int rest = 100-progresses[i];
            day[i] = rest / speeds[i]; //올림으로 묶어서 처리해도 가능
            if(rest % speeds[i] != 0) day[i] += 1;
        }
        
        
        int count = 1; 
        int max = day[0];
        for(int i = 1; i < day.length; i++) {
            if(max >= day[i]){
                count++;
            } else {
                list.add(count);
                max = day[i];
                count = 1;
            }
        }        
        list.add(count);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}