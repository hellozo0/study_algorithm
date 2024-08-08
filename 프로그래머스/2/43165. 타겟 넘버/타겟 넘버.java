class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        DFS(numbers,target, 0,0);
        
        return answer;
    }
    
    public static void DFS(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length){
            if(sum == target) answer++;
        } else {
            DFS(numbers,target,index+1, sum + numbers[index]);
            DFS(numbers,target,index+1, sum - numbers[index]);
        }
        
    }
}