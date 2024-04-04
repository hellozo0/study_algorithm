class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { //방문X면
                dfs(computers, i, visited); //노드 3개 
                answer++;
            }
        }

        return answer;
    }

    private boolean[] dfs(int[][] computers, int i, boolean[] visited) {
        //방문 ㅇ
        visited[i] = true;
        
        for(int j = 0; j < computers.length; j++) {
            //인데스마다 매번 반복  ( i = 3, 연결정보 길이 : j )
            if(i != j && computers[i][j] == 1 && visited[j] == false) {
                visited = dfs(computers, j, visited);
            }
        }
        return visited;
    }
}