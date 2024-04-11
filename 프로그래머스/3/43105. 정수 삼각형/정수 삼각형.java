import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            //left
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            
            //middle
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
            
            //right
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];   
        }
        
        //max 찾아내기
        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(dp[triangle.length-1][i], answer);
        }
        
        return answer;
    }
}