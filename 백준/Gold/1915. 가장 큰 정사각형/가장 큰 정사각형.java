
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];

        int max = 0;
        for(int i = 0; i<n; i++) {
            String s = br.readLine();
            for(int j = 0; j<m; j++) {
                dp[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));

                if(dp[i][j] == 1 && i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }

                if( dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }

        System.out.println(max*max);

    }
}
