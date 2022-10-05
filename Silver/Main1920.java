package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());    
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<M; i++){
            B[i] = Integer.parseInt(st2.nextToken());    
        }

        for (int i = 0; i < M; i++){
            int low = 0;
            int high = N-1;

            while(low <= high){

                int mid = (low + high) / 2;

                if (A[mid] < B[i]) {
                   low = mid + 1;
                } 
                else if (A[mid] > B[i]) {
                    high = mid -1;
                } 
                else {
                    System.out.println("1");
                    break;
                }

                if ( low > high) {
                    System.out.println("0");
                    break;
                }
            }
        }

    }
}
