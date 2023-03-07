import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int index = 0;
        
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = arr[0];
        
        //작은수가 뭔지 파악
        for(int i = 0; i < arr.length; i++){
            min = Math.min(min,arr[i]);
        }
        
        // answer 배열에 작은 수 빼고 넣기
        for(int i = 0; i < arr.length; i++){
            if ( arr[i] == min){
                continue;
            }
            
            answer[index++] = arr[i];
        }
        return answer;
    }
}