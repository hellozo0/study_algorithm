import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(operation.equals("I")){
                minPQ.add(num); 
                maxPQ.add(num); 
            } 
            else if(operation.equals("D") && num == 1 && !maxPQ.isEmpty()){
                int del = maxPQ.poll();
                minPQ.remove(del); 
            } else if (operation.equals("D") && num == -1 && !maxPQ.isEmpty()){
                int del = minPQ.poll();
                maxPQ.remove(del); 
            }

        }        
        if(minPQ.isEmpty()){
            answer = new int[] {0,0};
        } else {
            answer = new int[] {maxPQ.poll(), minPQ.poll()};
        }
            
        return answer;
    }
}