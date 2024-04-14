import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        //0. 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        //1. A 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //2. A 정렬하기 - O(nLogn)
        Arrays.sort(A);

        //3. 이진탐색
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int target  = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            boolean find = false;

            while(start <= end){
                int midIndex = (start+end)/2;
                int midValue = A[midIndex];

                if(midValue < target){
                    start = midIndex+1;
                }
                else if(midValue > target){
                    end = midIndex-1;
                }
                else {
                    find = true;
                    break;
                }
            }

            if(find) System.out.println("1");
            else System.out.println("0");
        }
    }
}
