import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        final int INF = 987654321;

        // 1. 자료구조 선언
        Edge[] edges = new Edge[M];
        long[] distance = new long[N + 1];

        // 2. 초기화
        Arrays.fill(distance, INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, w, v);
        }

        // 3. 벨만-포드 알고리즘
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] == INF) continue;
                
                if (distance[edge.end] > distance[edge.start] + edge.distance) {
                    distance[edge.end] = distance[edge.start] + edge.distance;
                }
            }
        }

        // 음수 사이클 확인
        boolean cycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.distance) {
                cycle = true;
                break;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        if (cycle) {
            sb.append("-1\n");  // 음수 사이클이 존재하면 -1 출력 후 종료
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) {
                    sb.append("-1\n");  // 도달 불가능한 경우 -1 출력
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Edge {
    int start;
    int end;
    int distance;

    Edge(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}