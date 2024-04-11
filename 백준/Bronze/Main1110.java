package 백준.Bronze;
import java.util.*;

public class Main1110 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int count = 0;
        int copy = N;

        while (true){
            N = ((N % 10) *10) + (((N/10) + (N % 10)) % 10);
            count++;

            if ( N == copy){
                break;
            }
        }

        System.out.println(count);

    }   
}
