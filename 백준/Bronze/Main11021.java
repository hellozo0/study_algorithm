package 백준.Bronze;
import java.util.*;


public class Main11021 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc;
        tc = sc.nextInt();
        int[] arr = new int[tc+1];

        for (int i = 1; i <= tc; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = a + b;
        }
        for (int i = 1; i <= tc; i++){
            System.out.println("Case #" + i + ": " + arr[i]);
        }
    }   
}
