package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {

    static int[] numArray;
    static long[] fiboArray;
    static int Zero;
    static int One;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        numArray = new int[T+1];

        for(int i = 0; i < T; i++){
            Zero = 0;
            One = 0;
            count = 0;
            numArray[i] = Integer.parseInt(br.readLine());
            fiboArray = new long[numArray[i] + 1];
            fibo(numArray[i]);
            System.out.println(Zero +  " " + One);
        }

    }

    static long fibo(int n){
        if(n == 0) {
            Zero++;
            return 0;
        }
        if( n == 1 ) {
            One++;
            return 1;
        }
        if(fiboArray[n] != 0){
            return fiboArray[n];
        }

        fiboArray[n] = fibo(n-1) + fibo(n-2);
        return fiboArray[n];
    }

}
