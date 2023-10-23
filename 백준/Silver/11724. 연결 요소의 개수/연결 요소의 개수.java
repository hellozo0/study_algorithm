import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int[][] arr;
    static int count;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        count = 1;
        int V = 1;

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        bfs(V);
        System.out.println(count);
    }
    public static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()){
            int next = q.poll();

            for(int i = 1; i < arr.length; i++){
                if(arr[next][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        for(int j = 1; j < arr.length; j++){
            if( visited[j] == false){
                count++;
                bfs(j);
            }
        }

    }
}
