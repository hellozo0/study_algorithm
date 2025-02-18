import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i = 1; i < N; i++){
            int max = 0;
            for(int j = 0;  j < i; j++){
                //작은거 있는지 체크
                if(array[j] < array[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
        }

        Arrays.sort(dp);
        System.out.print(dp[dp.length-1]);
    }
}