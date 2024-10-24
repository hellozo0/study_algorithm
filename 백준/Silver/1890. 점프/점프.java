
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] visited = new long[n+1][n+1];
        int[][] gameMap = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                gameMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[1][1] = 1;
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++) {
                if(i ==n && j == n) break; //마지막꺼 계산 X 
                if(i+gameMap[i][j] <= n) { //행
                    visited[i+gameMap[i][j]][j] += visited[i][j];
                }
                if(j+gameMap[i][j] <= n) { //행
                    visited[i][j+gameMap[i][j]] += visited[i][j];
                }
            }
        }
        System.out.println(visited[n][n]);
        
    }
}
