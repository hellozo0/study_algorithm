// 어우 어떻게 풀지 조차 X
import java.util.*;

class Solution {
  
    static char map[][] = new char[101][101];
    
    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        
        //rectangle 배열에서 테두리의 y,x 좌표를 각각 뽑아내고, 그 크기를 2배로 늘려서 칠해준다.
        //맵의 크기를 2배로 늘리는 이유는 BFS 를 하면서 테두리를 따라가는 중에 내 테두리가 아닌 옆의 테두리로 셀 수 도있기 때문이다. 테스트케이스 1번을 보면서 맵을 그려본다면 이해할 수 있을 것
        for(int i=0;i<rectangle.length;i++){
            int y1=rectangle[i][1];
            int x1=rectangle[i][0];
            int y2=rectangle[i][3];
            int x2=rectangle[i][2];  
            draw(y1*2,x1*2,y2*2,x2*2);
        }
        
        //BFS 를 해주면서 내 [상, 하, 좌, 우 ] 를 보고, itemY, itemX 를 찾는다. 찾고 나면 이제 그 좌표는 2배가 되어 있을 것이므로 count를 2로 나눈 값을 return 한다.
        return bfs(Y*2,X*2,itemY*2,itemX*2);
    }
    
    public static int bfs(int Y,int X,int findY,int findX){
        
        //상하 좌우 좌표들
        int yy[]={-1,1,0,0};
        int xx[]={0,0,-1,1};
        
        //큐 선언, visited 선언
        Queue<Integer[]> queue=new LinkedList<>();
        queue.add(new Integer[]{Y,X,0});
        boolean visited[][]=new boolean[101][101];
        
        //BFS
        while(!queue.isEmpty()){
            Integer temp[]=queue.poll();
            int prevY=temp[0];
            int prevX=temp[1];
            int count=temp[2];
            
            //2배로 다 해놨기 때문에 count도 /2
            if(prevY==findY&&prevX==findX)
                return count/2;
            
            //여기는 일반적인 좌표 BFS랑 동일 
            for(int i=0;i<4;i++){
                int nextY=prevY+yy[i];
                int nextX=prevX+xx[i];
                
                if(nextY<0||nextX<0||nextY>=map.length||nextX>=map[0].length) continue;
                if(visited[nextY][nextX]==true||map[nextY][nextX]!='2') continue;
                
                visited[nextY][nextX] = true;
                queue.add(new Integer[]{nextY,nextX,count+1});
            }
        }
        
        return 0;
    }
    
    //그리기
    public static void draw(int y1,int x1,int y2,int x2){
        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
            	if(map[i][j]=='1') continue;
                map[i][j]='1';
                if(i==y1||i==y2||j==x1||j==x2)
                    map[i][j]='2';
            }
        }
    }
}