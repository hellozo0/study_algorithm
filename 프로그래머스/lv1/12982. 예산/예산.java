import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;
        
        Arrays.sort(d); //오름차순 정렬
        
        while((budget - d[count]) >= 0){ 
            budget -= d[count];
            answer++;
            count++;
            
            if(d.length == count){
                return answer;
            }
        }
        
        return answer;
    }
}