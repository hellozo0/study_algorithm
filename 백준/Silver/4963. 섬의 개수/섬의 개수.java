import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int h;
    static int w;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            String line = br.readLine();
            if(line == null) break;

            st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            boolean[][] visited = new boolean[h][w];
            int[][] map = new int[h][w];
            answer = 0;

            for(int i = 0 ; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                }
            }

            for(int i = 0 ; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        bfs(visited, map, i,j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static void bfs(boolean[][] visited, int[][] map, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            //map[nowX + dx[i]][nowY + dy[i]]
            for(int i = 0; i < 8; i++){
                if(nowX + dx[i] < 0 || nowX + dx[i] > h-1 ||  nowY + dy[i] < 0 || nowY + dy[i] > w-1){
                    continue;
                }
                if(!visited[nowX + dx[i]][nowY + dy[i]] && map[nowX + dx[i]][nowY + dy[i]] == 1) {
                    queue.add(new int[]{nowX + dx[i], nowY + dy[i]});
                    visited[nowX + dx[i]][nowY + dy[i]] = true;
                }
            }

        }
    }
}