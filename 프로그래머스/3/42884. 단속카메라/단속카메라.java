import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //배열 안에 있는 요소 정렬( 나간시점 )
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int pos = Integer.MIN_VALUE;
        for(int[] r:routes){
            if(pos<r[0]){
                pos = r[1];
                answer++; //카메라 설치
            }
        }
        return answer;
        //-15
//         int min = routes[0][1];
//         for(int i = 1; i < routes.length; i++){
//             if(min <= routes[i][0]){
//                 answer++;
//                 min = routes[i][1];
//                 //근데 만약 3개 겹치는 경우가 있으면? 틀린다 이럴 경우엔 어떻게?
//             }
//         }
        
            
//         return answer;
    }
}  