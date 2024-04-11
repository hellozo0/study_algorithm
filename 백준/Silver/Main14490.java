package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        //num1, num2의 최대 공약수? 구해서 그걸로 계속 나누기..?

        int GCD = gcd(num1,num2);
        System.out.println(num1/GCD + ":"+ num2/GCD);
        
    }

    static int gcd(int a, int b){
        if (b == 0 ) return a;
        return gcd(b, a%b);
    }
}
