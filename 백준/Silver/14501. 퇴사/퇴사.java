
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        //뒤에서부터 접근
        //D[i+T[i]] + P[i] 이게 킥이다.... 어떻게 이런 식을 빨리 떠올리지?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 2];
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i >= 0; i--){
            if( i + t[i] > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i + t[i]] + p[i] );
            }
        }

        System.out.println(dp[1]);


    }
}
