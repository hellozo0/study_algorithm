
class Solution {
    
    static int answer;
    static boolean visited[];
    
    public int solution(String begin, String target, String[] words) {  
        answer = 0;
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            int check = 0;
            
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    check++;
                }
                
                if(check == begin.length() - 1){
                    visited[i] = true;
                    dfs(words[i], target, words, count+1); 
                    visited[i] = false;
                }
            }
        }
    }
}
