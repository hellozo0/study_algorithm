import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] A;
    static int visited[];
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        A = new ArrayList[n+1];
        
        //1. 인접리스트 초기화
        for(int i = 1; i <= n; i++){
            A[i] = new ArrayList<Integer>();
        }
        
        //2. 인접리스트에 값 넣기
        for(int i = 0; i < edge.length; i++){
            A[edge[i][0]].add(edge[i][1]);
            A[edge[i][1]].add(edge[i][0]);
        }
        
        //3. visited 초기화
        visited = new int[n+1];
        for(int i = 0; i <= n; i++){
            visited[i] = -1;
        }
        
        //4. BFS 로 거리 visited에 계산
        BFS(1);
        
        //5. visited max 값 찾기
        int max = -1;
        for(int i = 0; i < visited.length; i++){
            if(max < visited[i]){
                max = visited[i];
            }
        }
                
        //6. 개수 세기
        for(int i = 0; i < visited.length; i++){
            if(max == visited[i]){
                answer++;
            }
        }
        
    
        return answer;
    }
    
    private static void BFS(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start]++;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : A[now]){
                if(visited[i] == -1) {
                    visited[i] = visited[now] +1;
                    q.add(i);
                }
            }
        }
    }
    
}