package 백준.Bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine());
        int finish = 0;
        //18 

        for (int i = 0; i < N;i++){
            for (int j = 0; j < N; j++){
                if ( 5*j + 3 *i == N){
                    System.out.println(j+i);
                    finish = 1;
                    break;
                }
                if ( j == N-1 && i == N-1){
                    System.out.println("-1");
                }
            }
            if(finish == 1){
                break;
            }
        }
    }
}
