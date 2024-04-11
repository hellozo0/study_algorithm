import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    
    static void dfs(int index){
        visited[index] = true;
        
        for(int i=1; i<=N; i++){
            if(graph[index][i]==1 && !visited[i]) dfs(i);
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
				dfs(i);
				count++;
            }
        }
        
        System.out.println(count);
    }
}