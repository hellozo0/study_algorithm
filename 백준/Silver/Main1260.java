package 백준.Silver;


import java.io.IOException;
import java.util.*;

public class Main1260 {

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
        visited[V] = true;
        System.out.print(V + " ");

        for(int i = 1; i < arr.length; i++){
            if(arr[V][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        visited[V] = true;
        q.offer(V);

        while (!q.isEmpty()){
            int next = q.poll();
            System.out.print(next + " ");

            for(int i = 1; i < arr.length; i++) {
                if(arr[next][i] == 1 && visited[i] == false){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }



    }
}
