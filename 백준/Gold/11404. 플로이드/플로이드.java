
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
        StringTokenizer st; 
        int N = Integer.parseInt(br.readLine()); //5
        int M = Integer.parseInt(br.readLine()); //14

        list = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++) { //1~N까지
            list[i] = new ArrayList<>();
        }

        //1. 자료구조
        long[][] distance = new long[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];

        //2. 초기화
        for(int i = 1; i < N+1; i++){ //1~N까지
            for(int j = 1; j < N+1; j++) {
                distance[i][j] = Long.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
        }

        for(int i = 1; i < N+1; i++){
            dijkstra(i,distance, visited);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(distance[i][j] == Long.MAX_VALUE) {
                    bw.append("0 ");
                } else {
                    bw.append(String.valueOf(distance[i][j])).append(" ");
                }
            }
            if(i != N) bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();


        //나중에 반복문 돌면서 Long.MAX_VALUE이면 0으로 넣어서 출력해야함
    }

    private static void dijkstra(int start, long[][] distance, boolean[][] visited){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start][start] = 0;
        pq.add(new Edge(start,0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            if (visited[start][now.vertex]) continue;
            visited[start][now.vertex] = true;

            for(Edge next : list[now.vertex]){
                if(!visited[start][next.vertex] && distance[start][next.vertex] > distance[start][now.vertex] + next.value){
                    distance[start][next.vertex] = distance[start][now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[start][next.vertex]));
                }
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    long value;

    Edge(int vertex, long value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return Long.compare(this.value, e.value);
    }
}
