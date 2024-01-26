
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < 41; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int beforeVIP = 1;
        int count = 1;


        //예를 들어 9개의 좌석 중에 4, 7번이 VIP라면 7번전까지 계산하기
        for(int i = 0; i < M; i++){
            int VIP = Integer.parseInt(br.readLine());
            count *= dp[VIP - beforeVIP];
            beforeVIP = VIP + 1;
        }

        //8,9번 좌석에 대한 경우의수
        count *= dp[N+1-beforeVIP];

        System.out.println(count);
    }

}
