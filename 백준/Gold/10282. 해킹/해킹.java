
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //1. 자료구조 선언 및 초기화
            ArrayList<Edge>[] list = new ArrayList[n+1];
            boolean[] visited = new boolean[n+1];
            int[] distance = new int[n+1];
            for(int j = 1; j < n+1; j++) {
                //컴퓨터 3대
                list[j] = new ArrayList<>(); //1,2,3까지만 진행
            }
            Arrays.fill(distance, Integer.MAX_VALUE);

            //2. 간선 연결
            for(int k = 0; k < d; k++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list[v].add(new Edge(w,value));
                //여기서 반대로 방향 바꿨음
            }

            int count = 0;
            int max = Integer.MIN_VALUE;
            dijkstra(c, list,distance,visited);

            for(int z = 1; z < n+1; z++){
                if(distance[z] != Integer.MAX_VALUE){
                    count++;
                    max = Math.max(max, distance[z]);
                }
            }

            bw.write(count + " " + max + "\n");
            bw.flush();
        }
        bw.close();
    }

    private static void dijkstra(int start, ArrayList<Edge>[] list, int[] distance, boolean[] visited){
        //1. 엣지에 start 넣기
        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        //2. 다익스트라
        while (!pq.isEmpty()){
            Edge edge = pq.poll();

            if(visited[edge.vertex]) continue;
            visited[edge.vertex] = true;

            for(Edge next : list[edge.vertex]){
                if(distance[next.vertex] > distance[edge.vertex] + next.value){
                    distance[next.vertex] = distance[edge.vertex] + next.value;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
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

    @Override
    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}