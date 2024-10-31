
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //1. 자료구조 선언
        list = new ArrayList[V+1];
        int[][] distance = new int[V+1][V+1];
        boolean[][] visited = new boolean[V+1][V+1];


        //2. 초기화
        for(int i = 1; i < V+1; i++){
            for(int j = 1; j < V+1; j++){
                distance[i][j] = 9999999;
            }
        }
        for(int i = 1; i < V+1; i++){
            list[i] = new ArrayList<>();
        }

        //3. 입력받기
        for(int i = 0; i <E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
        }

        //4. 다익스트라
        for(int i = 1; i < V+1; i++) {
            dijkstra(i, distance, visited);
        }

        //5. 플로이드 워셜
        floyd(V, distance);

        int min = 9999999;
        for(int i = 1; i < V+1; i++){
            min = Math.min(min, distance[i][i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(min == 9999999?-1:min));

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dijkstra(int start, int[][] distance, boolean[][] visited){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start][start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[start][now.vertex]) continue;
            visited[start][now.vertex] = true;

            for(Edge next : list[now.vertex]){
                if(!visited[start][next.vertex] && distance[start][next.vertex] > distance[start][now.vertex] + next.value){
                    distance[start][next.vertex] = distance[start][now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[start][next.vertex]));
                }
            }
        }
    }
    private static void floyd(int V, int[][] distance){
        for(int i = 1; i < V+1; i++){
            distance[i][i] = 9999999;
        }
        // for(int i = 1; i < V+1; i++){
        //     for(int k = 1; k < V+1; k++){
        //         distance[i][i] = Math.min(distance[i][i], distance[i][k] + distance[k][i]);
        //     }
        // }
        for(int k = 1; k < V+1; k++){
            for(int i = 1; i < V+1; i++){
                for(int j = 1; j < V+1; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return value - e.value;
    }
}