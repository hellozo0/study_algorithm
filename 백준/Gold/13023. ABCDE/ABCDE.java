
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static ArrayList<Integer> A[];
    static boolean visited[];
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;

        //1. 초기화
        for(int i = 0; i < N; i++){
            A[i] = new ArrayList<>();
        }

        //2. 각 노드끼리 연결
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        //3. DFS
        for(int i = 0; i < N; i++){
            DFS(i , 1); //1은 depth
            if(arrive) break;
        }

        if(arrive) System.out.println("1");
        else System.out.println("0");

    }

    static void DFS(int node, int depth){
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[node] = true;
        for (int v : A[node]) {
            if(!visited[v]){
                DFS(v, depth+1);
            }
        }
        visited[node] = false;
    }
}
