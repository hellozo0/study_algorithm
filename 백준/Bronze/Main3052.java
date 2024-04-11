package 백준.Bronze;
import java.util.*;


public class Main3052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int count = 0;

        for(int i = 0;i<10;i++){
            arr[i] = sc.nextInt() % 42; 
            for(int j = 0; j < i;j++){ 
                if (arr[j] == arr[i]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(10-count);
        sc.close();
    }  
}
