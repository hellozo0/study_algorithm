
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
        long[] A = new long[N];

        for(int i = 0; i < N;i ++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        int answer = 0;

        for(int i = 0; i < N; i++){
            long target = A[i];
            int start = 0;
            int last = N-1;

            while (start < last) {
                if(A[start] + A[last] == target) {
                    if(start != i && last != i) {
                        answer++;
                        break;
                    }
                    else if (start == i) {
                        start++;
                    }
                    else if (last == i) {
                        last--;
                    }
                } else if (A[start] + A[last] > target){
                    last--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(answer);
    }
}