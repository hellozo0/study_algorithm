
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //1. 자료구조 선언
        ArrayList<Edge>[] list = new ArrayList[N];
        int[] scan = new int[N];
        long[] distance = new long[N];
        final long INF = Long.MAX_VALUE;

        //2. 초기화
        Arrays.fill(distance, INF);
        st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N;i++){
            scan[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        scan[N-1] = 0; //어차피 target

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
            list[v].add(new Edge(u,w));
        }

        //3. 다익스트라
        distance[0] = 0L;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            
            if(scan[now.vertex] == 1) continue;
            scan[now.vertex] = 1;

            for(Edge next : list[now.vertex]){
                if(scan[next.vertex] == 0 && distance[next.vertex] > distance[now.vertex] + next.value){
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }

        //4. 출력
        System.out.println(distance[N-1] != INF ? distance[N-1] : -1);

    }
}
class Edge implements Comparable<Edge>{
    int vertex;
    long value;

    Edge(int vertex, long value){
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return Long.compare(this.value, e.value);
    }
}