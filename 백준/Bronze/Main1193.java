package 백준.Bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main1193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int X = Integer.parseInt(br.readLine());
        
        
        //분모 분자 합이 홀수면 내려가는 것 

        //1,2,3,4,5
        //1,3,6,10,15
        int sum = 0;
        int cross_count = 1;
        int before_sum = 0;

        while(true){
            before_sum = sum; //0   1   3   6   10
            sum = sum + cross_count; //1,2   3,3     6,4     10,5    15,6

            if (X <= sum){//해당 번째를 알아내야함 --> cross_count알아냄
                int Xth = X - before_sum;
                if (cross_count %2 == 0){ //짝수 --> 아래로
                    System.out.println((Xth)+ "/" + (cross_count+1-Xth));
                    break;
                }
                else{ //홀수  --> 위로  //5  --> 분모 분자 합은 6
                    System.out.println( (cross_count+1-Xth) + "/" + (Xth));
                    break;
                }
            }
            cross_count++; //1, 2      3   4   5 
        }
		br.close();
    }
}
