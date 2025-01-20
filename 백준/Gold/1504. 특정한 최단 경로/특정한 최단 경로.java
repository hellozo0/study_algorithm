import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N,E;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] list;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점 개수
        int E = Integer.parseInt(st.nextToken()); //간선 개수

        //1. 자료구조 선언
        visited = new boolean[N+1];
        distance = new int[N+1];
        list = new ArrayList[N+1];

        //2. 초기화
        for(int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
            list[w].add(new Edge(u,v));
        }
        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int distance1 = 0; // v1 -> v2
        int distance2 = 0; // v2 -> v1

        //3. 다익스트라 시작
        //1 -> v1 -> v2 -> N
        distance1 += dijkstra(1,node1);
        distance1 += dijkstra(node1,node2);
        distance1 += dijkstra(node2,N);

        //1 -> v2 -> v1 -> N
        distance2 += dijkstra(1,node2);
        distance2 += dijkstra(node2,node1);
        distance2 += dijkstra(node1,N);

        System.out.println((distance1 >= INF && distance2 >= INF) ? -1 : Math.min(distance1,distance2));

    }

    private static int dijkstra(int start, int end){
        //1. 여러번 돌려야하니까 초기화
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        //2. 필요한 자료구조
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(!visited[now.node]){
                visited[now.node] = true;

                for(Edge next : list[now.node]) {
                    if(!visited[next.node] && distance[next.node] > distance[now.node] + next.value){
                        distance[next.node] = distance[now.node] + next.value;;
                        pq.add(new Edge(next.node, distance[next.node]));
                    }
                }
            }
        }
        return distance[end];
    }
}

class Edge implements Comparable<Edge>{
    int node;
    int value;

    Edge(int node, int value){
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e){
        return this.value - e.value;
    }
}