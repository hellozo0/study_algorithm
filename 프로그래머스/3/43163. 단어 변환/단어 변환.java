import java.util.*;

class Solution {
    
    static boolean visited[];
    static int answer;
    
    public int solution(String begin, String target, String[] words) {  
        //선언
        answer = 0;
        visited = new boolean[words.length];
        
        DFS(begin, target, words, 0);
        return answer;
    }
    
    public void DFS(String begin, String target, String[] words, int count){
        //1. target이 되었으면 finish
        if(begin.equals(target)){
            // System.out.println("여기여기여기여기여기여기");
            answer = count;
            return;
        }
        
        //2. 반복문을 돌며 검색
        for(int i = 0; i < words.length; i++){
            //(1) words를 방문했으면 건너 뛰기
            if(visited[i]) continue;
            
            //(2) begin과 words로 가기 적합한 것이 있으면 변경, DFS, visited, count++
            int checkWord = 0;
            for(int j = 0; j < begin.length(); j++){
                //(3) i 번재 word랑 begin 중에 적합한 대상 찾기 
                if(begin.charAt(j) == words[i].charAt(j)){
                    checkWord++;
                }
                
                //(4) 글자가 1개만 다른 경우 -> 해당 words로 다시 DFS
                if(checkWord == begin.length() - 1){
                    visited[i] = true;
                    DFS(words[i], target, words, count+1);
                    visited[i] = false;
                }
            }
        }
    }
}