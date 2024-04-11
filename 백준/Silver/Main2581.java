package 백준.Silver;
import java.util.Scanner;


public class Main2581 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        
        int sum = 0;
        int min = N;

        for(int i = M; i <= N; i++){ //M이상 N 이하
            boolean Test = true;

            if (i == 1){
                continue;
            }

            for (int j = 2; j <= Math.sqrt(i); j++){
                if ( i % j == 0){
                    Test = false;
                    break;
                }
            }

            if (Test){
                sum += i;
                if (min > i){
                    min = i;
                }
            }
        }
        if (sum  == 0 ){
            System.out.println("-1");
        }
        else{
            System.out.println(sum + "\n" + min);
        }
    }
}
