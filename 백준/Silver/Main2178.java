package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2178 {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        visited[0][0] = true;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y}); //방문 한거 넣기

        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int nowX = now[0]; //1
            int nowY = now[1]; //1

            for(int i = 0;i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY] == false && arr[nextX][nextY] == 1){
                    queue.offer(new int[] {nextX, nextY});
                    arr[nextX][nextY] = arr[nowY][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
