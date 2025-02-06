
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// public class Main {
//
//     static boolean[] visited;
//     static int[] distance;
//     static ArrayList<Edge>[] list;
//     static int N;
//     static int M;
//     static final int INF = 20000001;
//
//     public static void main(String[] args) throws IOException {
//
//         //1. 입력받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//
//         //2. 초기화
//         distance = new int[N+1];
//         visited = new boolean[N+1];
//         list = new ArrayList[N+1];
//         for(int i = 1; i < N+1; i++){
//             list[i] = new ArrayList<>();
//         }
//
//         //3. 노드들 입력 받기
//         for(int i = 0;i < M; i++){
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//
//             list[u].add(new Edge(w,v));
//         }
//
//         //4. 이제 벨만 포드의 기본인 다익스트라 => 최대거리를 먼저 구하고
//         Arrays.fill(distance,-INF);
//         dijkstra(1,N);
//         int maxDistance = distance[N];
//
//         //5. 벨만포드 ( 사이클 확인 용도로 한번더 진행) => 양수 사이클을 한번더 판단
//         Arrays.fill(distance,-INF);
//         Arrays.fill(visited, false);
//         dijkstra(1,N);
//         if(maxDistance != distance[N]) {
//             System.out.print(-1);
//         }
//
//
//         //(1) 최장거리르 먼저 구하고
//         //(2) 최장거리 한번 더 돌려서 값이 바뀌면 ( 사이클이 있다는 의미 ) => -1출력
//         //(3) 문제는 경로를 어떯게 구하는거지?
//
//     }
//
//     private static void dijkstra(int start, int target){
//         //1. 초기세팅
//         distance[start] = 0;
//         PriorityQueue<Edge> pq = new PriorityQueue<>();
//         pq.add(new Edge(start, 0));
//
//         while (!pq.isEmpty()){
//             Edge now = pq.poll();
//
//             if(visited[now.node]) continue;
//             visited[now.value] = true;
//
//             for(Edge next : list[now.node]){
//                 if(distance[next.node] < distance[now.node] + next.value) {
//                     //지금까지의 거리 + 다음으로 가는 거리
//                     distance[next.node] = distance[now.node] + next.value;
//                     pq.add(new Edge(next.node, distance[next.node]));
//                 }
//             }
//         }
//     }
// }
//
// class Edge implements Comparable<Edge>{
//     int node;
//     int value;
//
//     Edge(int node, int value){
//         this.node = node;
//         this.value = value;
//     }
//
//     @Override
//     public int compareTo(Edge e){
//         return e.value - this.value;
//     }
// }



//다시 풀기
//양수 사이클을 판단하고, 내 목적지에 가는 길에 있는 유효한 사이클인지를 판단해야한다 
//아래의 코드는 구글링 코드 

public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;

    private static int vertexCount;
    private static int edgeCount;
    private static int[][] edges;
    private static int[] distanceFromSource;
    private static int[] predecessor;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(READER.readLine());
        vertexCount = Integer.parseInt(tokenizer.nextToken());
        edgeCount = Integer.parseInt(tokenizer.nextToken());

        init();
        bellmanFord();

        if (distanceFromSource[vertexCount] == Integer.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (distanceFromSource[from] == Integer.MIN_VALUE) {
                continue;
            }

            if (isCycle(from, to, weight) && isCycleOnPath(to)) {
                System.out.println(-1);
                return;
            }
        }

        printShortestPath();
    }

    private static void init() throws IOException {
        edges = new int[edgeCount][];
        for (int i = 0; i < edgeCount; i++) {
            tokenizer = new StringTokenizer(READER.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            edges[i] = new int[]{from, to, weight};
        }

        distanceFromSource = new int[vertexCount + 1];
        predecessor = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            distanceFromSource[i] = Integer.MIN_VALUE;
            predecessor[i] = -1;
        }
        distanceFromSource[1] = 0;
    }

    private static void bellmanFord() {
        for (int i = 0; i < vertexCount - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if (distanceFromSource[from] == Integer.MIN_VALUE) {
                    continue;
                }
                if (distanceFromSource[to] < distanceFromSource[from] + weight) {
                    distanceFromSource[to] = distanceFromSource[from] + weight;
                    predecessor[to] = from;
                }
            }
        }
    }

    private static boolean isCycle(int from, int to, int weight) {
        return distanceFromSource[to] < distanceFromSource[from] + weight;
    }

    private static boolean isCycleOnPath(int targetVertex) {
        boolean[] visit = new boolean[vertexCount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(targetVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (visit[currentVertex]) {
                continue;
            }
            visit[currentVertex] = true;

            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];

                if (from == currentVertex && !visit[to]) {
                    queue.add(to);
                }
            }
        }

        return visit[vertexCount];
    }

    private static void printShortestPath() {
        StringBuilder sb = new StringBuilder();
        int index = vertexCount;
        sb.append(vertexCount);
        while (predecessor[index] != -1) {
            sb.insert(0, predecessor[index] + " ");
            index = predecessor[index];
        }
        System.out.print(sb.toString());
    }
}