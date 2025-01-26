
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = new int[]{1,0,-1,0}; //우,하,좌,상
    static int[] dy = new int[]{0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        //1. 입력받기
        for(int i = 1; i <=N; i++){
            String line = br.readLine();
            for(int j = 1; j <=N; j++){
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        //2. BFS로 2중 포문으로 요소 하나하나 다 찾아볼까..?
        //BFS로 누적합 하다가 다 끝나면 ArrayList에 넣고
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <=N; j++){
                if(!visited[i][j] && map[i][j] == 1) { //1이구 방문안했을때 bfs 시작
                    bfs(i,j);
                }
            }
        }

        //3. 출력
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] now = queue.poll(); //1이니까 들어왔겠지?

            //4방향 체크해야함 => 1인지 0인 누적합 할거니까
            for(int i = 0; i < 4; i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= N && map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                    cnt++;
                }

            }
        }
        answer.add(cnt);
    }

}