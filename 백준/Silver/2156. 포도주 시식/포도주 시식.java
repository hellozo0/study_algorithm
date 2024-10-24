
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] grapeArr = new int[n+1];
        for (int i = 1; i <= n; i++){
            grapeArr[i] = Integer.parseInt(br.readLine());
        }
        //6,10,13,9,8,1
        dp[0] = 0;
        dp[1] = grapeArr[1];
        if(n > 1) {
            dp[2] = grapeArr[1] + grapeArr[2];
        }

        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+grapeArr[i-1]+grapeArr[i], dp[i-2]+grapeArr[i]));
        }

        System.out.println(dp[n]);

    }
}
