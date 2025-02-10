import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()); //target
        int count = 0;
        
        if(N == 0) {
            System.out.print(0);
            return;
        }

        while (N > 1){
            if(N % 2 == 1) {
                N = (N/2) + (N%2);
            } else {
                N /= 2;
            }
            count++;
        }
        System.out.print(count+1);
    }
}