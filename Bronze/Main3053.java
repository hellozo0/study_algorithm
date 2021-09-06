package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main3053 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double R = Double.parseDouble(br.readLine());  //Double로 받기 

    
        System.out.printf("%.6f\n", (Math.PI * R * R)); 
        System.out.printf("%.6f\n", ((double)2 * R * R)); 
    }
}
