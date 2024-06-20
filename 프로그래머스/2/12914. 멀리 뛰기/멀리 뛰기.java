class Solution {
    public long solution(int n) {
        
//         long[] dp = new long[n+1];
//         dp[1] = 1;
//         dp[2] = 2;
        
//         if(n < 3) return dp[n];
        
//         for(int i = 3; i <=n; i++){
//             dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
//         }
        
//         return dp[n] % 1234567;
        long[] answer = new long[2001];
        answer[1] = 1;
        answer[2] = 2;
 
        for (int i = 3; i < 2001; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }
 
        return answer[n];
                
        // long answer = 1;
        //2를 0개, 1개, 2개 2xi <= 
        // int i = 1; 
        // while(2 * i <= n){
        //     answer += (n - (2 * i) + 1) % 1234567;
        //     i++;
        // }
        
    }
}