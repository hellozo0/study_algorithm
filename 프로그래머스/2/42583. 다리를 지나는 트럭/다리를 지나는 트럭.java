import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++){
            
            while(true){
                //큐 비어 있음
                if(q.isEmpty()){ //i =0일떄 7번 트럭
                    q.add(truck_weights[i]); // q = {7}
                    sum+= truck_weights[i]; //sum = 7
                    answer++; // answer = 1
                    break; // i = 1로 넘어감
                } 
                else if (q.size() == bridge_length) {//다리가 꽉 찼을때, i = 1일때 두번째 반복문 돌때 
                    sum -= q.poll(); // 맨 앞의 트럭을 빼줌 , q = {0} ...i =2일때 q = {4}
                }
                else { //큐가 비어있지 않았을 때 , i = 1일때 3번째 반복문 돌때 ,  
                    if(sum + truck_weights[i] > weight){ // 7 + 4 > 10
                        q.add(0); //0을 넣음 ㅂ = {7, 0} ... {5,0}
                        answer++; // answer = 2 .. answer = 5
                    } else { // 0 + 4 < 10, i = 2일때 4+5 < 10
                        q.add(truck_weights[i]); // q = {0, 4} , q = {4,5} , q= {0,6}
                        sum += truck_weights[i]; // sum = 4, sum = 9 , sum = 6
                        answer++; // answer = 3 , answer = 4 ... answer = 6
                        break; // i = 2로 간다. i = 3으로 간다  break  끝남,,! answer 6일때 

                    }
                }
            }
        }
        //마지막 차가 다리에 올랐을때 끝이 난다 그래서 마지막 차가 통과 하는 시간 포함하기
        return answer + bridge_length;
    }
}  