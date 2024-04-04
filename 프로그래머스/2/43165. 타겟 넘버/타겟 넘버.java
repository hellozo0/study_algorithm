class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers,target,0,0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int idx, int sum){
        // index 증가시키며 검사 ( target이랑 같은지 )
        if(idx == numbers.length){
            if(sum == target) answer++;
        } else{ // 더하고 빼고 반복 재귀 
            dfs(numbers, target, idx+1, sum+numbers[idx]);
            dfs(numbers, target, idx+1, sum-numbers[idx]);
        }
    }
}