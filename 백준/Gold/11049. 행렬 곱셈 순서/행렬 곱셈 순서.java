import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 구선생 참고
1. 부분 해를 메모이제이션 하는 이차원 DP 배열을 사용한다.
2. DP[i][j] 는 i부터 j까지 행렬 곱 연산의 최소값이다.
3. i와 j의 interval을 늘려가면서 최종적으로 DP[0][N-1]을 구할 수 있다.
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] process = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            process[i][0] = Integer.parseInt(st.nextToken());
            process[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int k=1; k<N; k++) {
            for(int i=0; i+k<N; i++) {
                dp[i][i+k] = Integer.MAX_VALUE;
                for(int j=i; j<i+k; j++)
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k] + process[i][0]*process[j][1]*process[i+k][1]);
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
