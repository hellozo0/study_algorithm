import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){
            int num = citations.length-i;
            if( citations[i] >= num) { 
                answer = num; // 인덱스 값이 아니라 기준 값 넘는 값
                break;
            }       
        }
        
        return answer;
    }
}