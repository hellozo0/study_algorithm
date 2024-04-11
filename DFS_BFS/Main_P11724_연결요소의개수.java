package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_P11724_연결요소의개수 {

    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        //1. A인접리스트의 각 ArrayList 초기화
        for(int i = 1; i < n+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        //2. 엣지별로, A 인접리스트에 그래프 데이터 저장하기 (양방향엣지인거 기억해라)
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        //3. 방문여부에 따라 DFS 실행
        int count = 0;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){ //방문 안했으면
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }

    static void DFS(int v){
        if(visited[v]) return;//true 먄 return;

        visited[v] = true;
        for(int i : A[v]){
            if(visited[i] == false) DFS(i); //재귀
        }
    }

}
