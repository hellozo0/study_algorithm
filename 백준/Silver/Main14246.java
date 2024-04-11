package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14246 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i ++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());


        int end = 0;
        int count = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            while(end < N) {
                if(sum > K){
                    count += (N - end) + 1; // 해당 start인 i 부터 뒤에 남은 개수 만큼 더 할 수 있으니 더하기
                    sum -= A[i];

                }else {
                    sum += A[end++];
                }
            }



        }

        System.out.println(count);

    }
}