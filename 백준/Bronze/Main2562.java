package 백준.Bronze;
import java.util.*;

public class Main2562 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max_arr,count_arr = 0;

        for (int i = 0; i < 9; i++){
            arr[i] = sc.nextInt();
        }
        max_arr = arr[0];

        for (int j = 0; j < 9; j++){
            if(max_arr <= arr[j]){
                max_arr = arr[j];
                count_arr = j+1;
            }
        }
        System.out.println(max_arr);
        System.out.println(count_arr);
    
        sc.close();

    }   
}
