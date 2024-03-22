import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        
        //0. parents 세팅
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        
        //1. 가중치 순으로 정렬
        //011 131 022 125 238
        Arrays.sort(costs, (o1,o2)-> o1[2] - o2[2]);
        
        for(int i = 0; i < costs.length; i++){
            //2. 연결되어 있는지 확인 - 연결안되어 있다면 연결
            if(find(costs[i][0]) != find(costs[i][1])){
                //3. 연결 안되어 있으면 연결하고 answer++
                union(costs[i][0], find(costs[i][1]));
                answer += costs[i][2];         
            }
        }
        
        return answer;
    }
    
    //union : 둘을 연결
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if( a != b){
            parents[b] = a;
        }
    }
    
    //최상위 부모 헤드 찾기
    private int find(int a){
        if(parents[a] == a) return a; //기초 세팅 상태랑 같으면 그거 return
        else return parents[a] = find(parents[a]); // 그래서 결국은 최상위 헤드 찾기
    }
}