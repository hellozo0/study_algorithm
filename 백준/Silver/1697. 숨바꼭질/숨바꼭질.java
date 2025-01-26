import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if(N == K) System.out.println("0");
        else bfs(N);

    }
    private static void bfs(int now){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = 1;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 0; i < 3; i++){
                int next = 0;

                if(i == 0) {
                    next = temp + 1;
                } else if(i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if(next == K) {
                    System.out.println(visited[temp]);
                    return;
                }

                if(next >= 0 && next < 100001 && visited[next] == 0){
                    queue.add(next);
                    visited[next] = visited[temp] + 1;
                }

            }
        }
    }
}