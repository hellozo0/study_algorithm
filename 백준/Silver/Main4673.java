package 백준.Silver;
import java.util.*;

public class Main4673 {
    public static void main(String[] args){
        
        boolean[] check = new boolean[10001];

        for(int i = 0; i < 10001; i++){
            int n = d(i);

            if (n < 10001){
                check[n] = true;
            }
        }

        for(int j = 0; j < 10001; j++){
            if (!check[j]) { //false
                System.out.println(j);
            }
        }
    }


    public static int d(int n){
        int sum = n;

        while (n != 0){
            sum += (n % 10); //첫 째 자리수 ex. 1234 -> 1234 + 4,3,2,1
            n = n / 10; //10을 나누어  첫 째 자리를 없앤다   --> 다 나누고 0이 되면 탈출
        }

        return sum;
    }
}
