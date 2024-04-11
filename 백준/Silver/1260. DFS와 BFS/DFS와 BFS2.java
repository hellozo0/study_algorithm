import java.io.IOException;
import java.util.*;

public class Main {


    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        arr = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

    }

    public static void dfs(int V){
        visited[V] = true; //특정 노드 이미 방문 (1) visited[1]1 = true (2) visited[2] = true (4) visited[4] = true (5) visited[3] = true
        System.out.print(V + " "); // (1) 1 출력 (2) 2출력  (3) 4출력 (4) 3출력....!!
        
        for(int i = 1; i < arr.length; i++){
            if(arr[V][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()){
            int next = queue.poll(); //(1) 1
            System.out.print(next + " ");

            for(int i = 1; i < arr.length; i++){
                if(arr[next][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}
