package 백준.Bronze;
import java.util.*;


public class Main10871 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i< N;i++){
            arr[i] = sc.nextInt();
        }

        for (int j = 0; j <N; j++){
            if (arr[j] < X){
                System.out.print(arr[j]+ " ");
            }
        }
    }   
}
