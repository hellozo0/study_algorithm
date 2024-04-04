import java.util.*;

class Solution {
    
    //좌우 방향 
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        //방문 여부 체크하는 함수, 정답
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);
        
        //answer - 최단 개수 
        int answer = visited[maps.length-1][maps[0].length-1];
        //도달 못한 경우
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    private void bfs(int[][] maps, int[][] visited){
        
        //시작 좌표 0,0
        visited[0][0] = 1; 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] now = queue.remove();
            int startX = now[0]; //x좌표
            int startY = now[1]; //y좌표
            
            for(int i = 0; i < 4; i++){
                int nX = startX + dx[i]; //좌우위아래 방향 적용한 index
                int nY = startY + dy[i]; //좌우위아래 방향 적용한 index
                
                //맵의 범위가 아닐 경우 패스 
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                //방문하지 않았고, 맵이 지나갈 수 있는 곳일 경우 
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    //방문 누적합 
                    visited[nX][nY] = visited[startX][startY] + 1; 
                    queue.add(new int[]{nX, nY});
                }
                
            }   
        }
    }
}