import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IceBerg {
    int x;
    int y;

    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        // 빙하가 2개 이상 분리될 경우 반복문을 종료.
        // 빙하가 다 녹아버렸을 경우, 0을 출력.
        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            Melt();
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 빙하가 분리된 개수를 구하는 함수.
    public static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited); // DFS 방식을 통해 총 몇개의 빙하로 나누어졌는지 구할 수 있음.
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int dx, dy;
        for (int i = 0; i < 4; i++) {
            dx = x + rangeX[i];
            dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }

            if (map[dx][dy] != 0 && !visited[dx][dy]) {
                DFS(dx, dy, visited);
            }
        }
    }

    // 빙하를 녹이는 함수.
    public static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();

        // visited 배열을 만드는 이유

        // visited 배열이 없다면,
        // 만약 1 2 가 있는 상태에서 1이 먼저 녹아서 0이 될 경우
        // 2는 녹아서 없어진 1 자리도 0이라고 판단하여
        // 필요 이상으로 더 많은 값을 녹이게 되어 버림.
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!q.isEmpty()) {
            IceBerg ice = q.poll();

            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.

            for (int i = 0; i < 4; i++) {
                dx = ice.x + rangeX[i];
                dy = ice.y + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }

            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
