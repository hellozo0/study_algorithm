package 백준.Bronze;
import java.util.*;

public class Main11022 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc;
        tc = sc.nextInt();

        for (int i = 0; i < tc; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case #" + (i+1) + ": " + a+" + "+b+" = " + (a+b));
        }
    } 
    
}
