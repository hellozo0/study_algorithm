import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        //우선순위큐 문제 3221 ,  911111 저장 될것이다.
        
        for(int i = 0; i < priorities.length; i++){
            q.add(priorities[i]);
        }
        
        while (!q.isEmpty()) { //3221일때 , 911111
            for (int i = 0; i < priorities.length; i++) { //index0부터 비교 
                if (q.peek() == priorities[i]) { //i = 2일때 , i = 2일때,3,4,5,0
                    q.poll(); //3을 큐에서 뺀다, 9을 뺀다
                    answer++; // answer = 1이 되고, answer = 1,,2,3,4,5

                    if (i == location) { //location이랑 i랑같을때 
                        return answer; // answer = 1 , 5 리턴
                    }
                }
            }
        }
        
        return answer;
    }
}