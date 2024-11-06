
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // write code...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //NxN 사이즈
        int K = Integer.parseInt(st.nextToken()); //바이러스 이름

        boolean[][] visited = new boolean[N+1][N+1];
        int[][] map = new int[N+1][N+1];
        int[] dx = new int[]{-1,0,1,0}; //위, 오른쪽, 아래, 왼쪽
        int[] dy = new int[]{0,1,0,-1};
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.virus - o2.virus);

        //1. 입력받기
        for(int i = 1; i <=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    pq.add(new Edge(i,j,map[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //몇 초후
        int X = Integer.parseInt(st.nextToken()); //해당 인덱스 확인 결과
        int Y = Integer.parseInt(st.nextToken());

        //2. 로직 S초 될때마다, 2초면 두번 돌리는거임
        for(int i = 0; i < S; i++){
            //한 턴이 끝나고 pq에 넣기
            Queue<Edge> queue = new LinkedList<>();

            while (!pq.isEmpty()){
                Edge edge = pq.poll();

                for(int j = 0; j < 4; j++){
                    int nextX = edge.x + dx[j];
                    int nextY = edge.y + dy[j];

                    if(nextX > 0 && nextX < N+1 && nextY > 0 && nextY < N+1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = edge.virus;
                        queue.add(new Edge(nextX, nextY, edge.virus));
                    }
                }
            }
            //한턴이 끝나면 pq에 바이러스 우선순위대로 넣기
            while (!queue.isEmpty()){
                pq.add(queue.poll());
            }
        }
        
        //결과출력
        bw.write(map[X][Y] + "\n");
        bw.flush();
        bw.close();

    }
}

class Edge {
    int x;
    int y;
    int virus;

    Edge(int x, int y, int virus){
        this.x = x;
        this.y = y;
        this.virus = virus;
    }
}