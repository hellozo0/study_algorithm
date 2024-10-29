
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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        //1. 필요한 자료구조 선언
        boolean[] visited = new boolean[V+1];
        int[] distance = new int[V+1];
        ArrayList<Edge>[] list = new ArrayList[V+1];

        //2. 자료구조 초기화
        for(int i = 1;i < V+1; i++){
            list[i] = new ArrayList<Edge>();
            distance[i] = Integer.MAX_VALUE;
        }

        //3. 값 넣기
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }

        //4. 다익스트라 진행
        pq.add(new Edge(startNode,0));
        distance[startNode] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nowVertex = now.vertex;
            if(visited[nowVertex]) continue; //방문한적 있으면 스루
            visited[nowVertex] = true; // 첫방문이면 방문 처리

            //1이랑 연결된거 다 파악
            for(int i = 0; i < list[nowVertex].size(); i++){
                Edge next = (Edge)list[nowVertex].get(i);
                int nextVertex = next.vertex;
                int nextValue = next.value;
                if(distance[nextVertex] > distance[nowVertex] + nextValue){
                    distance[nextVertex] = distance[nowVertex] + nextValue;
                    pq.add(new Edge(nextVertex, distance[nextVertex]));
                }
            }
        }

        for(int i = 1; i < V+1; i++){
            if( visited[i]) {
                System.out.println(distance[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        return -1;
    }
}