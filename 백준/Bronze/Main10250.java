package 백준.Bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st;
		    st = new StringTokenizer(br.readLine()," ");
        
            int H = Integer.parseInt(st.nextToken()); //세러
            int W = Integer.parseInt(st.nextToken()); //가로
            int N = Integer.parseInt(st.nextToken()); //번쨰

            //10 12 10 
            if(N % H == 0) {
            	System.out.println((H * 100) + (N / H));
            }
            else {
            	System.out.println(((N % H) * 100) + ((N / H) + 1)); //6 12 10
		}
        }

    }
}
