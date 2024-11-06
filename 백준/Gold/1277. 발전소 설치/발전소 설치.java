
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//다시 풀어봄
public class Main {
    static int N, W;
    static double M, INF = 200001;
    static Edge[] edge;
    static boolean[][] connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine()); //max 길이

        edge = new Edge[N + 1];
        connected = new boolean[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            //00, 01, 11, 21, 22, 32, 33, 41, 43 좌표 넣음
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            connected[u][w] = true;
            connected[w][u] = true;
        }

        System.out.println(dijstra());
    }

    private static long dijstra() {
        double[] distance = new double[N + 1];
        boolean[] visited = new boolean[N + 1];

        //1. 초기화
        Arrays.fill(distance, INF);
        distance[1] = 0;

        //2. 연결되어 있는 발전소는 distance = 0
        for (int i = 2; i < N + 1; i++) {
            if (connected[1][i]) distance[i] = 0;
        }

        //3. 다익스트라
        for (int i = 0; i < N; i++) {
            double minDistance = INF; //최소거리
            int cur = 0; //인덱스

            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && minDistance >= distance[j]) {
                    minDistance = distance[j];
                    cur = j;
                }
            }

            if (cur == N) break;

            visited[cur] = true;
            for (int j = 1; j < N + 1; j++) {
                if (j == cur) continue;
                int next = j;
                if (distance[next] > distance[cur] + getDistance(cur, next)) {
                    distance[next] = distance[cur] + getDistance(cur, next);
                }
            }
        }
        return (long) (distance[N] * 1000);
    }

    private static double getDistance(int cur, int next) {
        if (connected[cur][next]) return 0;

        Edge src = edge[cur];
        Edge dest = edge[next];
        double dist = Math.pow(src.x - dest.x, 2) + Math.pow(src.y - dest.y, 2);
        dist = Math.sqrt(dist); // 유클리드 거리 계산
        return dist > M ? INF : dist;
    }
}

class Edge {
    int x;
    int y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}