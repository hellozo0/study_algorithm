package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;

        //반복문을 사용해서 구현
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] +1; //dp[2] = 1, dp[3] = 2(1), dp[4] = 2(2), dp[5] = 3, dp[6] = 2
            if ( i % 2 == 0 ){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3] +1);
            }
        }
        System.out.println(dp[N]);
        //무조건 큰 수로 나누는 것이 최솟값이 아니기 때문에 아래와 같은 방법(처음내가 구현한 방식)은 틀리다. 
        // 3나누기 2 나누기 1빼기의 순으로 처리하면 안된다



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
