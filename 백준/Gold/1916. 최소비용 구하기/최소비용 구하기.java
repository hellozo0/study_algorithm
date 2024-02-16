
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static List<Node>[] list;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        /*
        * 다익스트라 개념 구글링
        * - 주로 Node 객체 생성해서 많이 품
        *   1. 벨만포드 알고리즘 (Bellman-Ford Algorithm)  -> 음수 간선이 포함된 상황에 사용하면 좋음
            2. 다익스트라 알고리즘(Dijkstra Algorithm)  -> 하나의 정점에서 다른 모든 정점의 최단 경로
            3. 플로이드 와샬 알고리즘(Floyd-Warshall Algorithm) -> 모든 정점에서 모든 정점의 최단 경로
        */


        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());


        dijkstra(start);
        System.out.println(dp[destination]);

    }

    static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        q.add(new Node(start, 0));
        dp[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int to = node.to;

            if (check[to]) continue;

            check[node.to] = true;
            for (Node next : list[to]) {
                if (dp[next.to] >= dp[to] + next.cost) {
                    dp[next.to] = dp[to] + next.cost;
                    q.add(new Node(next.to, dp[next.to]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
