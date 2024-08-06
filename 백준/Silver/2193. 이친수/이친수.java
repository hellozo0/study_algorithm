import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);

    }
}
