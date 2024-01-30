import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int max = -12345;
        int sum = 0;
        int N = Integer.parseInt(st.nextToken()); // 날짜의 개수
        int K = Integer.parseInt(st.nextToken()); // 연속된 날짜
        int[] temp = new int[N];

        st =  new StringTokenizer(br.readLine()); // 연속된 온도 입력
        for(int i = 0; i < N; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - K + 1; i++){
            sum = 0;
            for(int j = 0; j < K; j++){
                sum += temp[i+j];
            }
            if( max < sum ) max = sum;
        }

        System.out.println(max);

    }
}
