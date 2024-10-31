
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        long[] distance = new long[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //2. 초기화
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        //3. 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1 && i != N-1) {
                visited[i] = true;
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
            list[w].add(new Edge(u,v));
        }

        //4. 다익스트라
        pq.add(new Edge(0,0));
        distance[0] = 0L;

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.vertex]) continue;
            visited[now.vertex] = true;

            for(Edge next : list[now.vertex]){
                if(!visited[next.vertex] && distance[next.vertex] > distance[now.vertex] + next.value){
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }

        System.out.println(distance[N-1] == Long.MAX_VALUE?-1:distance[N-1]);

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