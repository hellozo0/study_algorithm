
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        long[] A = new long[N];
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for(int k = 0; k < N; k++){
            long target = A[k];
            int i = 0;
            int j = N-1;

            while(i < j){
                if( A[i] + A[j] == target){
                    if(i != k && j != k){
                        answer++;
                        break;
                    } else if ( i == k){
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }

        }

        System.out.println(answer);

    }
}
