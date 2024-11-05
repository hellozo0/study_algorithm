
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //1. 자료구조 선언
        // ArrayList<Edge>[] list = new ArrayList[n+1];
        // int[][] edge = new int[n+1][n+1];
        int[][] distance = new int[n+1][n+1];
        int[][] answer = new int[n+1][n+1];

        //2. 초기화
        // for(int i = 1; i < n+1; i++){
        //     list[i] = new ArrayList<>();
        // }
        for(int i = 0; i < n+1; i++) {
            Arrays.fill(distance[i], 9000);
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // list[u].add(new Edge(w,v));
            // list[w].add(new Edge(u,v));
            // edge[u]
            distance[u][w] = v;
            distance[w][u] = v;
            answer[u][w] = w;
            answer[w][u] = u;
        }

        //3. 플로이드 워셜
        for(int k = 1; k < n+1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) {
                        distance[i][j] = 0;
                        answer[i][j] = 0;
                        continue;
                    }
                    //[i][k] [k][j]
                    if( distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        //이 부분을 모르겠다 왜지? [1][6] = [1][2] == 0 이라면 ...2넣고 0 
                        answer[i][j] = answer[i][k] == 0 ? k : answer[i][k];
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if( i == j ) {
                    bw.write("- ");
                    continue;
                }
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}

class Edge {
    int vertex;
    int value;

    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }
}