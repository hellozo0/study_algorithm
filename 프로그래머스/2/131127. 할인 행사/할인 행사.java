import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sum = 0;
        
        for(int i = 0; i < number.length; i++){
            sum += number[i];
        }
        
        int start = 0;
        int end = sum-1;
        List<String> wantList = new ArrayList<>(Arrays.asList(want));
        
        for(int i = 0; i < discount.length; i++){
            if(start > discount.length - sum) break;
            
            if( i <= end){
                if(wantList.indexOf(discount[i]) != -1) {
                    number[wantList.indexOf(discount[i])] -= 1;
                }
            }
            
            if( i == end) {
                if(valid(number)){
                    answer += 1;
                }
                if(wantList.indexOf(discount[start]) != -1) {
                    number[wantList.indexOf(discount[start])] += 1;
                }
                start += 1;
                end += 1;
            }
        }
        
        return answer;
    }
    
    private boolean valid(int[] number){
        for(int i = 0; i < number.length; i++){
            if(number[i] > 0) return false;
        }
        return true;
    }
}