import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // pq.add(0);
        // pq.add(1);
        // pq.add(2);
        // System.out.println(pq.peek());
        
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        
        while(!pq.isEmpty()) { // 2번쨰 while 돌때 
            for(int i = 0; i < priorities.length; i++) {
                //i = 3 일때 0[3]1[4]1[5]1[6], 1[0]1[1]
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++; //1-> 2-> 3-> 4
                    
                    if( i == location ) return answer;
                }
            }
        }
        
        
        
        
        
        
        
        return answer;
    }
}