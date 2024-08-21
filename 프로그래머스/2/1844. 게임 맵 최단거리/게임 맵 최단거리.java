import java.util.*;

class Solution {
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; //아래, 오른쪽, 위, 왼쪽
    static int[][] visited;
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        
        BFS(maps);
        
        int answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    static void BFS(int[][] maps){ //i랑 j는 시작점
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = 1; //0,0
        
        while(!queue.isEmpty()){
            int[] now = queue.remove(); //0,0,
            
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k]; 
                int y = now[1] + dy[k];
                
                if(x < 0 || x > maps.length-1 || y < 0 || y > maps[0].length-1) continue;
                
//                 if(x >=0 && y >= 0 && x < maps.length && y < maps[0].length) {
                    
//                 }
                if(visited[x][y] == 0 && maps[x][y] == 1) {
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y});
                }
            }
        }
    }
}