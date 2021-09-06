package Bronze;
import java.util.*;

public class Main10818 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int min_arr,max_arr;
        
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        min_arr = arr[0];
        max_arr = arr[0];
        for (int j = 0; j < N; j++){
            if (min_arr > arr[j]){
                min_arr = arr[j];
            }
            if (max_arr < arr[j]){
                max_arr = arr[j];
            }
        }
        System.out.println(min_arr+" "+max_arr);

        sc.close();
    }   
}
