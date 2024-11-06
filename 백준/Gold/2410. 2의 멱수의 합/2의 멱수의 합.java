import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        // write code...ㄹ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        final int toAnswer = 1000000000;

        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for(int i = 4; i <= N; i++){
            if(i % 2 == 0) { //짝수일때의 규칙
                dp[i] = (dp[i-1] + dp[i/2]) % toAnswer;
            } else { //홀수일때의 규칙
                dp[i] = dp[i-1] % toAnswer;
            }
        }
        bw.write(dp[N] +"\n");
        bw.flush();
        bw.close();
    }
}