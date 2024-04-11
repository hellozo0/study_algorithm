import java.util.PriorityQueue;
import java.util.Queue;


class Solution {
    
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            q.add(scoville[i]);
        }
        
        while( q.peek() < K){
            
            if(q.size() < 2) { //요소가 없을때 
                return -1;
            }
            q.add(q.poll() + q.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}