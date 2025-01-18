
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0;i < tc; i++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            String letter = st.nextToken();

            for(int j =0; j < letter.length();j++){
                char c = letter.charAt(j);
                for(int k = 0; k < count; k++) {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());

        }
    }
}