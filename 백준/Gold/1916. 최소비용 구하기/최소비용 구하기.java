
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //1. 자료구조 선언
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        ArrayList<Edge>[] list = new ArrayList[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //2. 초기화
        for(int i = 1; i < N+1; i++){
            list[i] = new ArrayList<Edge>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(w,v));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int targetNode = Integer.parseInt(st.nextToken());

        //3. 다익스트라 시작
        pq.add(new Edge(startNode,0));
        distance[startNode] = 0;

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int nowCity = now.node;

            if(visited[nowCity]) continue;;
            visited[nowCity] = true;

            for(Edge next : list[nowCity]){ //다음노드들
                int nextCity = next.node;
                int nextBus = next.value;
                if(distance[nextCity] > distance[nowCity]+ nextBus) {
                    distance[nextCity] = distance[nowCity]+ nextBus;
                    pq.add(new Edge(nextCity, distance[nextCity]));
                }
            }
        }
        System.out.println(distance[targetNode]); //무조건 가는 길이 있느건가? 만약에 없으면? 뭐를 출력해라 이런게 없다

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
        return value - e.value;
    }
}