class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1; 
        int sum = 0; 
        
        while (start <= end && end <= n+1) {
            if(sum == n) {
                answer++;
                sum -= start++;
            } else if ( sum < n) {
                sum += end++;
            } else { //sum > n
                sum -= start++;
            }
        }    
        return answer;
    }
}