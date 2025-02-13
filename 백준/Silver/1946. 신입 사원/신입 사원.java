import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i <T; i++){
            ArrayList<int[]> rank = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                rank.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            Collections.sort(rank, (o1, o2) -> o1[0] - o2[0]);
            int ans = 1;
            int min = rank.get(0)[1];

            for(int k =  1; k < rank.size(); k++){
                if(rank.get(k)[1] < min) {
                    ans++;
                    min = rank.get(k)[1];
                }
            }
            System.out.println(ans);
        }
    }
}
