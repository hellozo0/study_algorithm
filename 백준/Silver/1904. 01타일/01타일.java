import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] tiles = new long[N+2];
        tiles[0] = 0;
        tiles[1] = 1;
        tiles[2] = 2;

        for(int i = 3; i <= N; i++){
            tiles[i]  = (tiles[i-1] + tiles[i-2]) % 15746;
        }

        System.out.println(tiles[N]);
    }
}
