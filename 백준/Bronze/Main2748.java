package 백준.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2748 {

    static long[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = new long[n+1];

        System.out.println(fibo(n));

    }

    static long fibo(int n){
        if( n == 1 || n == 2) return 1;
        if( n == 0) return 0;
        if(array[n] != 0) return array[n];

        array[n] = fibo(n-1) + fibo(n-2);
        return array[n];

    }
}
