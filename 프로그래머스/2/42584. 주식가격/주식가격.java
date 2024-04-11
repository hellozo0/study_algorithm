import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] <= prices[j]){ //i -> 2
                    answer[i]++;
                }
				if (prices[i] > prices[j]) { // 크면 다음 인데스 비교
                    answer[i]++;
					break;
				}
            }
        }
        
        return answer;
    }
}