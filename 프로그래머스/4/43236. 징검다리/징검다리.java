import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        //1.준비 및 세팅
        int answer = 0;
        int start = 0;
        int end = distance;
        
        Arrays.sort(rocks);
        
        //2. 이진탐색 
        while(start <= end) {
            
            //2. 선언 
            int mid = (start + end) / 2;
            int remove = 0;
            int prev = 0;
            
            //
            for(int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid)
                    remove++;
                else
                    prev = rocks[i];
            }
            // 이 부분이 문제 
            // AI : 이진 탐색의 목적은 가장 짧은 거리 중 최대값을 찾는 것입니다. 따라서, 마지막 바위에서 도착지점까지의 거리를 mid와 비교하는 것이 아니라, 귀하의 이진 탐색 로직에 올바르게 통합되도록 확인해야 합니다. 여기서 힌트는 이진 탐색 과정 중에 모든 바위들 사이의 거리뿐만 아니라 마지막 바위에서 도착 지점까지의 거리도 이진 탐색 조건에 맞게 적용될 필요가 있다는 것입니다. 이 부분을 재검토하여 조금만 수정하면 올바른 답을 얻을 수 있을 것입니다.
            if(distance - prev < mid && remove <= n) remove++;
            
            // 바위 간격의 최솟값을 mid
            if(remove <= n) {
                answer = mid;
                start = mid + 1;
            }
            else {end = mid - 1;}
            
        }
        return answer;
    }
}