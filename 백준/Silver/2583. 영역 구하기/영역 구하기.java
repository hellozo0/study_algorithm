import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static int M;
    static int N;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken());  //7
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M]; //[7][5]
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for(int x = startX; x < endX; x++){
                for(int y = startY; y < endY; y++){
                    visited[x][y] = true;
                }
            }
        }

        //DFS
        for(int i = 0; i < N; i++) { //N = 7
            for(int j = 0; j < M; j++){ //=M = 5
                if(!visited[i][j]){
                    count = 0;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) +" ");
        }
    }

    private static void DFS(int x, int y){
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M) continue;
            if(!visited[nowX][nowY]) {
                DFS(nowX,nowY);
            }
        }
    }
}
