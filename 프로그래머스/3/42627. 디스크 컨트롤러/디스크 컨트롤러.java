import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //시작 기점으로 일단 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        //큐선언 ( 작업시간이 가장 짧은 순으로 )
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1]);
        
        int answer = 0; // 수행시작 누적 합
        int end = 0; // 작업이 끝난 시점 인덱스
        int jobIdx = 0; // 작업 배열의 인덱스
        int count = 0; //요청 개수
        
        while(count < jobs.length){ // 요청이 다 될때 까지
            
            //(1) 큐에 값을 넣기 [jobsIdx < jobs.length]를 왜 하는지 모르겠음, 이 부분을 떠올리기가 어렵다
            // 작업이 끝났을 시점까지 바로 실행가능한 작업이 있을 경우 -> 큐에 다 넣는다
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                pq.add(jobs[jobIdx++]);
                //여기서 이 Idx가 만약에 작업 idx 0 -> 3 -> 2 -> 1 막 이런식이면 어캄??
                //아 마지막 작업 이후에.... 일 경우..?음...엄..모르겠다 
                //일단 없으면 런타임 에러가 뜬다^^
            }
            
            
            //(2) 큐가 비어 있으면 -> 다음 요청까지 공백 텀이 있다는 것
            if(pq.isEmpty()){
                end = jobs[jobIdx][0];
            } else { //(3) 큐가 비어 있지 않으면 수행시간 계산 시작
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0]; //수행 시간 + 시작 시점부터 실제로 시작한 시점의 차이
                end += temp[1];
                count++;
                
            }
            
        }
        
        
        
        
        return answer/jobs.length;
    }
}