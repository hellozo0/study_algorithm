
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    private static boolean[][] visited;
    private static int[][] maps;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    static List<Integer> arr;
    private static int N;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        visited = new boolean[N][N];
        arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < N; j++) {
                maps[i][j] = s.charAt(j)-'0';
            }
        }

        c = 1;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && maps[i][j] == 1){
                    cnt++;
                    dfs(i,j);
                    arr.add(c);
                    c = 1;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(arr);

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) != 0){
                System.out.println(arr.get(i));
            }
        }


    }

    private static void dfs(int i, int j){
        visited[i][j] = true;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i,j});

        while (!stack.isEmpty()){
            int[] now = stack.pop();
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if( x >= 0&& y>=0 && x < N && y < N && !visited[x][y] && maps[x][y] == 1){
                    visited[x][y] = true;
                    stack.push(new int[]{x,y});
                    c++;
                }
            }
        }
    }

}
