class Solution {
    static int[] info;
    static int[][] edges;
    static int maxSheepCnt;
    
    public int solution(int[] info, int[][] edges) {
        Solution.info = info;
        Solution.edges = edges;
        maxSheepCnt = 0;
        boolean[] visited = new boolean[info.length];
        dfs(0,visited,0,0);
        
        return maxSheepCnt;
    }
    
    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt){
        //방문 처리하고 
        visited[idx] = true;
        
        //양이면
        if(info[idx] == 0) {
            sheepCnt++;
            maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);
        } else { //늑대면
            wolfCnt++;
        }
        
        //양 == 늑대 개수 같으면 똥
        if(sheepCnt <= wolfCnt) {
            visited[idx] = false;
            return;
        }
        
        for(int[] edge : edges) {
            //시작점에서 다음점으로 이동하는 조건
            if(visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = visited.clone();
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }        
    }
}