package Bronze;
import java.util.*;


public class Main1546 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double[] arr = new Double[N];
        Double M;
        Double sum = (double) 0;

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextDouble();
        }

        M = arr[0];
        for (int j = 1; j < N; j++){
            if (M < arr[j]){
                M = arr[j];
            }
        }

        for (int k = 0; k <N; k++){
            sum += (arr[k] / M) * 100;
        }
        System.out.printf("%.2f" ,(sum/N));

        sc.close();
    }  
}
