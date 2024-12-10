import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean map[][] = new boolean[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        HashMap<Integer, Character> timeInfo = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        for(int i = 0; i <L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char way = st.nextToken().charAt(0);
            timeInfo.put(time,way);
        }

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        int x = 1;
        int y = 1;
        int time = 0;
        int d = 0;
        boolean flag = true;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1,1});

        while(true){
            time++;

            int nx = x + dx[d];
            int ny = y + dy[d];


            //벽에 닿았을 때
            if(nx < 1 || ny < 1 || nx > N || ny > N) {
                break;
            }

            //몸통 박치기
            for(int i  =0; i < list.size(); i++){
                int[] snake = list.get(i);
                if(snake[0] == nx && snake[1] == ny) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                break;
            }


            //이동
            if(map[nx][ny]) { //사과 있음
                map[nx][ny] = false;
                list.add(new int[]{nx,ny});
            } else {
                list.add(new int[]{nx,ny});
                list.remove(0);
            }

            //방향 전환
            if(timeInfo.containsKey(time)) {
                if(timeInfo.get(time) == 'D') {
                    d++;
                    if(d == 4) d = 0;

                } else {
                    d--;
                    if( d == -1) d = 3;
                }
            }
            x = nx;
            y = ny;
        }
        System.out.println(time);
    }
}
