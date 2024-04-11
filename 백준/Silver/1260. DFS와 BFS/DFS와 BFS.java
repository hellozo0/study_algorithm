import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main{
    
    static int N,M;
    static ArrayList<Integer>[] nodeList;
    static boolean[] isVisted;


    public static void dfs(int V) {
        if(isVisted[V]) return;

        System.out.print(V + " ");
        isVisted[V] = true;

        //해당 노드에 존재하는 노드 수 만큼 반복
        for(int i = 0; i< nodeList[V].size();i++){
            int MIN = 1001;

            //  헤당 노드가 가장 낮은 수 인지 모두 방문해서 검증
            for(int j = 0; j < nodeList[V].size(); j++){
                int cur  = nodeList[V].get(j);

                if(!isVisted[cur]) {
                    MIN = Math.min(MIN,cur);
                }
            }

            if(MIN == 1001) break;
            dfs(MIN);
        }
    }

    private static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();

        q.add(V);
        isVisted[V] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            // 해당 노드에 존재하는 노드 수만큼 반복
            for (int i = 0; i < nodeList[node].size(); i++) {
                int MIN = 1001;

                // 해당 노드가 가장 낮은 수인지 모두 방문하여 검증
                for (int j = 0; j < nodeList[node].size(); j++) {
                    int cur = nodeList[node].get(j);

                    if(!isVisted[cur]) {
                        MIN = Math.min(MIN, cur);
                    }

                }

                if(MIN == 1001) break;

                q.add(MIN);
                isVisted[MIN] = true;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        int V = Integer.parseInt(st.nextToken()); 

        nodeList = new ArrayList[N+1]; //정점의 수대로 배열 생성
        isVisted = new boolean[N+1]; //방문 여부 판단

        //간선 리스트 초기화
        //1번 정점부터 리스트를 만들어서 배열에 넣기
        for(int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        //간선수 대로 반복하면서 연결리스트 생성
        for(int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st2.nextToken()); 
            int to = Integer.parseInt(st2.nextToken()); 

            //양방향 
            nodeList[from].add(to);
            nodeList[to].add(from);
        }

        dfs(V);

        Arrays.fill(isVisted,false);
        System.out.println();

        bfs(V);

    }
}
