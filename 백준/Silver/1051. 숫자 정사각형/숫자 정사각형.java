
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                square[i][j] = s.charAt(j) - '0';
            }
        }

        //어차리 최대 3인 N만큼씩만 비교
        int max = Math.min(N, M);


        while (max > 1) {
            for(int i = 0; i <= N-max; i++){
                for (int j = 0; j <= M-max; j++){
                    int value = square[i][j];
                    if(value == square[i][j+max-1] && value == square[i+max-1][j]  && value == square[i+max-1][j+max-1] ){
                        System.out.print(max*max);
                        return;
                    }
                }
            }
            max--;
        }

        System.out.print(max*max);

    }
}