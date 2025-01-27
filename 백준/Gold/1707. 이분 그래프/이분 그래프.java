
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //1. K번의 테스트 진행
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            //노드 수는 20,000인데
            //간선의 수는 200,000개임... 인접리스트 쓰는게 좋을거 같은데?
            ArrayList<Integer>[] array = new ArrayList[V + 1];
            // boolean[] visited = new boolean[V+1];
            //visited가 아니라 컬러로 하자!!1
            int[] color = new int[V+1];
            flag = true;

            //2. 초기화
            for (int j = 1; j <= V; j++) {
                array[j] = new ArrayList<>();
            }

            //3. 값 입력 받기
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                array[u].add(w);
                array[w].add(u);
            }

            //4. dfs로 풀어보기 사이클 있는지
            for (int j = 1; j <= V; j++) {
                if(!flag) {
                    break;
                }
                if(color[j] == 0) {
                    dfs(array, color, j);
                }
            }

            System.out.println(flag?"YES":"NO");

        }
    }

    private static void dfs(ArrayList<Integer>[] array, int[] color, int start){
        Stack<Integer> stack = new Stack<>();
        color[start] = 1;
        // visited[start] = true;
        stack.push(start);

        while(!stack.isEmpty()){
            int now = stack.pop();

            for(int next : array[now]){
                //색 겹치면 탈락
                if(color[next] == color[now]) {
                    flag = false;
                    return;
                }

                //방문 안했으면
                if(color[next] == 0) {
                    stack.push(next);
                    color[next] = -color[now];
                }
            }
        }

    }
}
