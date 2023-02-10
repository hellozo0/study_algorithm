
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = n; i > 0 ; i--){
            if (n % i == 0){
                answer += i + (n / i);
            }   
        }
        answer /= 2;
        
        return answer;
        
    }
}