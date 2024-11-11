//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Stack;
// import java.util.StringTokenizer;
//
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         int h = Integer.parseInt(st.nextToken());
//         int w = Integer.parseInt(st.nextToken());
//
//         int[][] map = new int[N+1][M+1];
//         boolean[][] visited = new boolean[N+1][M+1];
//         for(int i = 1; i <=N; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j = 1; j <= M; j++){
//                 map[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }
//
//         int k = Integer.parseInt(br.readLine());
//         Edge[] hole = new Edge[k];
//         Stack<Edge> stack = new Stack<>();
//
//         for(int i = 0; i < k; i++) {
//             st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());
//             hole[i] = new Edge(x,y, map[x][y]);
//             stack.add(hole[i]);
//             // visited[x][y] = true;
//         }
//
//
//         int[] dx = new int[]{-1,0,1,0}; //위, 오른쪽, 아래, 왼쪽
//         int[] dy = new int[]{0,1,0,-1};
//
//         //stack에 2개 들어가 있는 상태
//         //DFS
//         while (!stack.isEmpty()){
//             Edge now = stack.pop();
//             int nowX = now.x;
//             int nowY = now.y;
//             int nowH = now.h;
//             visited[nowX][nowY] = true;
//
//             for(int i = 0; i < 4; i++){
//                 // if(nowX + dx[i] < 1 || nowY + dy[i] < 1 || nowX + dx[i]> N || nowY + dy[i] > N) continue;
//                 if(nowX + dx[i] >= 1 && nowX + dx[i] <= N && nowY + dy[i] >= 1 && nowY + dy[i] <= M && nowH <= map[nowX + dx[i]][nowY + dy[i]] && !visited[nowX + dx[i]][nowY + dy[i]]){
//                     stack.add(new Edge(nowX + dx[i], nowY + dy[i], map[nowX + dx[i]][nowY + dy[i]]));
//                 }
//             }
//         }
//
//         //자 이제... 신발 크기 만큼 되는거 파악하기
//         // visited로 돌리면 될듯
//         int count = 0;
//         for(int i = 1;  i <= N; i ++) {
//             for(int j = 1; j <= M; j++){
//                 if(!visited[i][j]) continue;
//
//                 boolean flag = true;
//                 for(int i1 = 0; i1 < h; i1++){
//                     for(int j1 = 0; j1 < w; j1++){
//                         if(i + i1 > N || j + j1 > M) {
//                             flag = false;
//                             continue;
//                         }
//                         if(!visited[i+i1][j+j1]) {
//                             flag = false;
//                         }
//                     }
//                 }
//                 if (flag) count++;
//             }
//         }
//         System.out.println(count);
//     }
// }
//
// class Edge {
//     int x;
//     int y;
//     int h;
//
//     Edge(int x, int y, int h){
//         this.x = x;
//         this.y = y;
//         this.h = h;
//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, h, w;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 위, 오른쪽, 아래, 왼쪽
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        Queue<Edge> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Edge(x, y, map[x][y]));
            visited[x][y] = true;
        }

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowH = now.h;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && nowH <= map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Edge(nx, ny, map[nx][ny]));
                }
            }
        }

        // 신발 크기에 맞게 영역 검사
        int count = 0;
        for (int i = 1; i <= N - h + 1; i++) {
            for (int j = 1; j <= M - w + 1; j++) {
                if (isAreaVisited(i, j)) count++;
            }
        }

        System.out.println(count);
    }

    // 영역 검사
    private static boolean isAreaVisited(int x, int y) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[x + i][y + j]) return false;
            }
        }
        return true;
    }
}

class Edge {
    int x, y, h;

    Edge(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}