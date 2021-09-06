package Silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
        
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 


        for(int i = M; i <=N; i++){
            boolean Test = true;

            if (i == 1){
                continue;
            }
            for(int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0) {
                    Test = false;
                    break;
                }
            }

            if (Test){
                System.out.println(i);
            }
        }
    }
}
