package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if (max < line[i]) {
                max = line[i];
            }
        }

        long min = 0;
        long mid = 0;
        max++; // (구글링) mid가 0일때, 0으로 나눠지는 문제 --> Upper Bonud는 원래 값 보다 +1 위치 값이니
        while(min < max) {

            mid = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < K; i++){
                count += line[i] / mid;
            }

            //Upper 구해야함
            if (count < N){
                max = mid;
            } 
            else {
                min = mid + 1;
            }

        }

        System.out.println(min-1);


    }
    
}
