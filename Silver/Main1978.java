package Silver;
import java.util.Scanner;

public class Main1978 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;
        

        for(int i = 0; i < N; i++){
            int k = sc.nextInt();
            boolean Test = true;

            if (k == 1){
                continue;
            }
            for (int j = 2; j <= Math.sqrt(k); j++){
                if ( k % j == 0){
                    Test = false;
                    break;
                }
            }
            if (Test){
                count++;
            }
        }
        System.out.println(count);
    }
}
