
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //200까지
        int K = Integer.parseInt(st.nextToken()); //200까지 목표 값

        //dp면 배열로 넣는 방법 밖에 없나? 바텀엄
        int[][]dp = new int[201][201];

        /** 0 도 더하는거 가능
         * K \  N=  0     1       2       3       4       5
         * 1    1
         * 2
         * 3
         * 4
         * */

        for(int i = 1; i <=K; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }

        System.out.print(dp[K][N]);

    }
}