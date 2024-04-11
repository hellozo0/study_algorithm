package 백준.Bronze;
import java.util.*;


public class Main10950 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc;
        tc = sc.nextInt();

        int arr[] = new int[tc];
        
        for (int i = 0; i <tc; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = a+b;
        }

        for (int j = 0; j < tc; j++){
            System.out.println(arr[j]);
        } 
    }   

}
