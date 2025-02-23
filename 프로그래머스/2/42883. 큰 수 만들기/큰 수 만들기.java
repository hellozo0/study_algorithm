import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        //앞에서 자르다가 큰 숫자 나오면 stop 
        // 즉 앞에 k 번쨰 중에 가장 큰 숫자 찾기 
        // (1) 큰 숫자 나올때 까지 앞에 다 cut
        // (2) 큰 숫자 뒤로 남은 k 번째 중에 바로 다음꺼 부터 나머지 뒤에 꺼 탐색
        // (2-2) 연달아 가다가 그 다음 께 더 크면 일단 kut,
        // (2-3) 또 다음거랑 비교해서 다음께 더 크면 kut..
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        for(int i = 0; i < number.length()-k; i++){
            char max = 0;
            
            //앞에서 부터 가장 큰 수 찾기 
            for(int j = index; j <= i+ k; j++){ //[0 ~ k = 2] ==> [다시 2부터 i = 1, k = 2 ~ 3]
                if(number.charAt(j) > max){
                    
                    max = number.charAt(j); //1924의 경우
                    index = j+1; //만약 j가 1일 떄 였으면 2부터 다시 비교 
                }
            }
            sb.append(Character.toString(max));
            
        }
        
        return sb.toString();
    }
}