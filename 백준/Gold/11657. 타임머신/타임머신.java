import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //[그래프 문제다] 다익스트라? ㄴㄴ 음수 가능한거 인지 해야하니까   ""벨만포드""
        //N개 도시 <= 500
        //M개 버스 <= 6000
        //C가 0이면 순간이동, C <0 이면 타임머신 시간 되돌림

        //만약 음수 사이클 있으면 -1출력,
        //아니라면 1=> 2 ,3,4,... 를 출력하깅~

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //1. 자료 구조 선언
        final int INF = 999999999;
        long[] distance = new long[N+1];
        Edge[] edges = new Edge[M];

        //2. 초기화 & 입력
        Arrays.fill(distance, INF);
        distance[1] = 0;
        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u,w,v);
        }

        //3. 벨만 포드 _ 시작점은 1
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){//j개 간선 수 만큼
                Edge now = edges[j];

                if(distance[now.u] != INF && distance[now.w] > distance[now.u] + now.v) {
                    distance[now.w] = distance[now.u] + now.v;
                }
            }
        }

        //4. 음수 사이클 탐색
        boolean cycle = false;
        for(int j = 0 ; j < M; j++){
            Edge now = edges[j];

            if(distance[now.u] != INF && distance[now.w] > distance[now.u] + now.v) {
                cycle = true; //이미 음수 사이클 있다는 말임
                break;
            }
        }

        //5. 조건 _ 반복문 출력
        StringBuilder sb = new StringBuilder();;
        if(cycle) {
            sb.append("-1");
        } else {
            for(int i = 2; i <=N; i++){
                if(distance[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}

class Edge{
    int u;
    int w;
    int v;

    Edge(int u, int w, int v) {
        this.u = u;
        this.w = w;
        this.v = v;
    }
}