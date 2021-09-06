package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main10872 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());  
        int factorial = 1;

        for(int i = tc; i > 0; i--){
            factorial *= i;
        }
        System.out.println(factorial);

    }
}

