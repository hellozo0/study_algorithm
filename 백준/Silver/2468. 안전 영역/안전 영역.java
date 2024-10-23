
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ScheduledExecutorService;

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxRain = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxRain < map[i][j]) maxRain = map[i][j];
            }
        }

        int answer = 0;
        for(int i = 0; i <= maxRain; i++){ //0부터 9 높이까지 10번을 ,,, 기준을 잡고 돌려야함
            visited = new boolean[n][n];
            int count = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k <n; k++){
                    if(!visited[j][k] && map[j][k] > i){
                        bfs(j,k,i);
                        count++;
                    }
                }
            }
            answer = Math.max(answer,count);
        }
        System.out.println(answer);
    }

    //해당 영역의 개수를 리턴해야함
    public static void bfs(int x, int y, int limit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll(); //현재 인덱스 now[0], now[1];

            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){//범위 안에 들면
                    if(map[nx][ny] > limit && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
