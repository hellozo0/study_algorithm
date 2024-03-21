import java.util.*;

class Solution {
    
    static private int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        //최소 비용 - 최소 신장 트리 ( 크루스칼, 프림 )
        //(1) 크루스칼 : 모든 간선을 가중치 기준으로 오름차순 정렬 -> 이 간선들을 순서대로 모든 정점이 연결될때 까지 연결
        // Union Find
        //(2) 프림 : 트리 집합을 단계적으로 확장하는 것이고, 새로운 정점을 연결할때 마다 새로운 정점에서 갈 수 있는 아직 연결되지 않은 정점들에 대한 간선을 추가
        // 우선순위 큐 사용
        
        int answer = 0;
        parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        //가중치로 정렬 
        // 011  131  022  125  238 순으로 정렬되겠지?
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        //크루스칼 
        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) { // 01 연결
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2]; // 가중치 누적합
            }
        }
        return answer;
    }
    
    //a가 어떤 집합에 포함되어 있는지 찾는 연산
    public int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    //a와 b가 포함되어 있는 집합을 합치는 연산
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a; // [i][1] 을 세팅
        }
    }
}