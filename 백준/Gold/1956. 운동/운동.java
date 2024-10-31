
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //1. 자료구조 선언
        int[][] distance = new int[V+1][V+1];

        //2. 초기화
        for(int i = 1; i < V+1; i++){
            for(int j = 1; j < V+1; j++){
                distance[i][j] = INF;
            }
        }
        
        //3. 입력받기
        for(int i = 0; i <E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            distance[u][w] = v;
        }

        //4. 플로이드 워셜
        floyd(V, distance);

        int min = INF;
        for(int i = 1; i < V+1; i++){
            min = Math.min(min, distance[i][i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min == INF?-1:min));

        bw.flush();
        bw.close();
        br.close();

    }

    private static void floyd(int V, int[][] distance){
        for(int k = 1; k < V+1; k++){
            for(int i = 1; i < V+1; i++){
                for(int j = 1; j < V+1; j++){
                    if(distance[i][k] != INF && distance[k][j] != INF){
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
    }


}
