
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge{
    int node;
    int value;

    public Edge(int node, int value){
        this.node = node;
        this.value = value;
    }
}

public class Main{

    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];

        for(int i = 1; i <= V; i++){
            A[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if( node == -1 ) break;
                int value = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(node, value);
                A[start].add(edge);
            }
        }

        BFS(1);
        int max = 1;
        for(int i = 2; i <= V; i++){
            if(distance[max] < distance[i]){
                max = i;
            }
        }

        visited = new boolean[V+1];
        distance = new int[V+1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[V]);

    }

    private static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(Edge i : A[now]){
                if(!visited[i.node]){
                    visited[i.node] = true;
                    queue.add(i.node);
                    distance[i.node] = distance[now] + i.value;
                }
            }
        }
    }
}
