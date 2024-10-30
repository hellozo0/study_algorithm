
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
        ArrayList<Edge>[] list = new ArrayList[N+1];
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //2. 초기화
        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
            list[w].add(new Edge(u,v));
        }

        pq.add(new Edge(1,0));
        distance[1] = 0;

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.vertex]) continue;
            visited[now.vertex] = true;

            for(Edge next : list[now.vertex]){ //(2,1) (4,4)
                if(distance[next.vertex] > distance[now.vertex] + next.value) {
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    pq.add(new Edge(next.vertex,distance[next.vertex]));
                }
            }

        }

        System.out.println(distance[N]);

    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e){
        return this.value - e.value;
    }
}

