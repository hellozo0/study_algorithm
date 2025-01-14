
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        * K개의 랜선을 N개의 길이로 만들고 싶음
        *
        * (조건)
        *  -  k(1<= K <= 10,000), N (1<= N <= 1,000,000)
        *  -  랜선 길이는 2^32 - 1 보다 작거나 같다
        *
        * ex) 300 => 140cm x 2 ... 20cm남음
        * (입력) K N 그리고 K개의 랜선들
        *
        * ** [포인트] 이분 탐색이네
        * ** N보다 타겟 값이 작으면 end = mid;
        * ** N이랑 같거나 크면 start = mid;
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[N];
        long start = 0, end = 0;

        for(int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            end = Math.max(end,lines[i]);
        }

        int target;
        end++; //이거 때문에 틀린것인가 ( 0~0 사이의 경우 때문에) *****
        long mid = (start + end) / 2;
        while(start < end) {
            mid = (start + end) / 2;
            target = 0;

            for(int i = 0; i < K; i++){
                target += lines[i] / mid;
            }

            if(target < N) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        System.out.println(start-1);
    }
}