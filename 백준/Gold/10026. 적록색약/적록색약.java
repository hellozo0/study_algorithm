import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //그러면 map에서 B 일때는 검색하지 않고
        //R이랑 G일때 검색을 하는데
        //1. R + G 같이 한번 탐색 같은 걸로 치고!
        // 그다음 R+G에서 쪼개서 구분해야겠는데 ==> 이걸 어떻게?
        // R + G 영역을 탐색해서 Queue에 넣고
        //그걸 pop하면서 R영역 G 영역 나누기? G가 떨어져 있으면 ? 따로 카운팅
        //ㄴㄴ 두번 탐색 먼저 해보고

        visited = new boolean[N][N];
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        //R,G,B
        int answer1 = 0;
        int answer2 = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(i,j);
                    answer1++;
                }
            }
        }
        //G -> R
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        // R+G && B
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(i,j);
                    answer2++;
                }
            }
        }
        System.out.print(answer1 + " " + answer2);

    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        char nowColor = map[x][y];

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                if (nowX + dx[i]>=0 && nowX + dx[i]<N && nowY+dy[i] >= 0 && nowY+dy[i] < N && !visited[nowX + dx[i]][nowY+dy[i]] && map[nowX + dx[i]][nowY+dy[i]] == nowColor){
                    queue.add(new int[]{nowX + dx[i],nowY+dy[i] });
                    visited[nowX + dx[i]][nowY+dy[i]] = true;
                }
            }
        }

    }
}