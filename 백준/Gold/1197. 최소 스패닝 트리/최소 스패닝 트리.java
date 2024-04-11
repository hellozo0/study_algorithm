/*
크루스칼 알고리즘 : 간선 중심으로 최소 신장 트리를 구하는 알고리즘 (간선이 적을 때 프림 알고리즘보다 유리)
1. 간선들을 가중치의 오름차순 정렬하여 가장 작은 간선 선택
2. 그 간선이 지금까지 만들어진 MST와 사이클을 형성한다면 제외, 아니면 MST에 추가
3. 모든 간선에 대해 반복

프림 알고리즘 : 정점 중심으로 최소 신장 트리를 구하는 알고리즘 (정점이 적을 때 크루스칼 알고리즘보다 유리)
1. 임의의 정점 선택
2. 그 정점과 인접한 정점을 잇는 간선 중 가중치가 가장 낮은 간선 선택
3. 그 간선이 연결하는 정점 선택, 모든 정점에 대해 2번 과정 반복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//Edge
class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    // 1. 우선 순위 큐 활용 (오름차순 정렬)
    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;
    }
}

public class Main {

    static StringTokenizer st;
    static int v; // 정점의 개수
    static int e; // 간선의 개수
    static int[] parent;
    static PriorityQueue<Edge> queue; // 간선 정보 저장

//    2. 그 간선이 지금까지 만들어진 MST와 사이클을 형성한다면 제외, 아니면 MST에 추가
//    3. 모든 간선에 대해 반복
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        parent = new int[v + 1];

        // 부모노드 세팅
        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 정보 입력 받음
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.offer(new Edge(v1,v2,weight));
        }

        //여기까지는 세팅 ------------------------------------------------


        // 사이클 확인 (union-find)
        int weight = 0;
        while(!queue.isEmpty()) {
            Edge cur = queue.poll(); // 가중치가 가장 작은 간선
            // 부모노드가 다를때만 (사이클X)
            if(find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                weight += cur.weight;
            }
        }
        System.out.println(weight);
    }

    // 합치기
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    // 부모 노드 찾기
    public static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

}
