
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] packPrice = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            packPrice[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <=n; i++){ //dp[1] = 1, dp[2] = 5, dp[3] = 6, dp[4] = 10
            for(int j = 1; j <=i; j++){ //j = 1,2,3,4   <->   i = 4
                dp[i] = Math.max(dp[i], dp[i-j] + packPrice[j]);
            }
        }
        System.out.println(dp[n]);

    }
}
