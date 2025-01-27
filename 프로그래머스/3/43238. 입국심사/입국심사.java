import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        
        //가장 적은 시간과 가장 긴 시간을 구하고 mid 값을 조절해서 가능한지 여부를 파악한다
        //1. low,high 세팅
        Arrays.sort(times);
        long low = 1;
        long high = n * (long)times[times.length-1];
        
        
        //1 ~ 60  ==> 30으로 가능한지 
        while(low <= high) {
            long mid = (low + high) /2; //30 
            long sum = 0;
            
            for(int time : times){
                sum += mid / time; //4, 3 => 7개
            }
            
            if(sum >= n) {
                answer = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        
        
        return answer;
    }
}