
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for(int i = 0; i < tc; i++){
            int num = Integer.parseInt(br.readLine());
            int[] woods = new int[num];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++) {
                woods[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(woods); //2,4,5,7,8
            int start = 0;
            int last = num-1;
            int[] woods2 = new int[num];
            for(int k = 0; k < num; k++){ //01234
                if(k % 2 == 0) {
                    woods2[start++] = woods[k]; //258
                } else {
                    woods2[last--] = woods[k]; //74
                } //25874
            }

            int max = woods2[num-1] - woods2[0];
            for(int m = 1; m < num; m++){
                max = Math.max(max, Math.abs(woods2[m]-woods2[m-1]));
            }
            System.out.println(max);
        }
    }
}
