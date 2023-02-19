class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 2부터 올리는 방법이 제일 짧은듯.../ 다른 사람 풀이 결과
        for (int i = n-1; i>0;i--){
            if ( n % i == 1){
                answer = i;
            }
        }
        return answer;
    }
}