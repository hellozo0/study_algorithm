import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); //최소힙
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2)-> o2 - o1); //최대힙
        
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            System.out.println("operation : " + operation + "   num : " + num );
            
            //큐가 비어있는데 D(삭제 연산)일 경우 무시
            if(minPQ.size() < 1 && operation.equals("D")){
                System.out.println("111111");
                continue;
            }
            
            if(operation.equals("I")){
                System.out.println("222222");
                minPQ.add(num); //큐에 다 넣는다
                maxPQ.add(num); //큐에 다 넣는다
            } 
            else if(operation.equals("D") && num == 1){ //최대값 삭제
                System.out.println("33333");
                int del = maxPQ.poll();
                minPQ.remove(del); //minPQ에서도 해당 숫자 삭제
            } else if (operation.equals("D") && num == -1){
                System.out.println("44444");
                int del = minPQ.poll();
                maxPQ.remove(del); //minPQ에서도 해당 숫자 삭제
            }

        }        
        if(minPQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
            
        return answer;
    }
}