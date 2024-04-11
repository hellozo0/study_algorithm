package 백준.Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine()); 

        //최소값을 저장할 배열을 dp로 만들었다
        int[] dp = new int[N+1];

        //0과 1일땐 따로 연산이 필요하지 않다.
        dp[0] = 0;
        dp[1] = 0;


        //반복문을 사용해서 구현 Bottom-Up 방식  <--> Top-Down 방식(재귀를 이용해서 계산하는 방식)
        //점화식을 이용한 다이나믹 프로그래밍 문제


        // [주의할점]
        // 무조건 큰 수로 나누는 것이 최솟값이 아니기 때문에 아래와 같은 방법(처음내가 구현한 방식)은 틀리다. 
        // 3나누기 2 나누기 1빼기의 순으로 처리하면 안된다 즉 "무조건 큰 수로 나눈다고 해결되진 않는다"


        //각 연산 마다 세울 수 있는 점화식은 아래와 같다
        //dp[N] = dp[N/3] + 1, dp[N] = dp[N/2] + 1, dp[N] = dp[N-1] +1
        //ex) dp[2] = dp[2/2] + 1 -> dp[2] = dp[1] + 1    => 1
        //ex) dp[3] = dp[3/3] + 1 -> dp[3] = dp[1] + 1    => 1
        //ex) dp[4] = dp[4/2] + 1 -> dp[4] = dp[2] + 1    => 2


        //[푸는법] 그리고 문제 그대로 n/2했을 때 n/3했을 때 n-1 했을 때 가장 최소값인 것을 찾아서 dp배열에 넣어주면 된다.
        //[푸는법] 가장 작은 값부터 차례대로 최소값을 구했다면, n번째 값을 구할 때 n이 3으로 나누어 떨어진다면 dp[n/3] 번째 값에 n/3을 연산한 횟수 1만 더해주면 될 것이다.
        for(int i = 2; i <= N; i++) {
            //dp[2] = 1, dp[3] = 2(1), dp[4] = 2(2), dp[5] = 3, dp[6] = 4(2) ... dp[7] = 3, dp[8] = 4(3), dp[9] = 4(2), dp[10] = 3(3)
            dp[i] = dp[i-1] +1; 

            if ( i % 2 == 0 ){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] +1);
            }
        }
        System.out.println(dp[N]);







        //---------------------------------------------- 
        // int count = 0;

        //3으로 먼저 나누고
        //2로 나누고 
        // -1 하기..! 
        //ex) 10이면 (3은 안된다) (2는된다 -> 5) (-1하면 4) (3은 안된다) (2는 된다 ->2 한번더-> 1) 4번..!

        // while(true){
        //     while ( N % 3 == 0){
        //         N = N / 3;
        //         count++;
        //     }
        //     while ( N % 2 == 0 ){
        //         N = N / 2;
        //         count++;
        //     }
        //     while( N % 3 != 0 && N % 2 != 0) {
        //         N = N - 1;
        //         count++;
        //     }
        //     if (N == 1){
        //         break;
        //     }
        // }
        
        // System.out.println(count);

    }
}
