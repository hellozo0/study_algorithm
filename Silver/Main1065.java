package Silver;
import java.util.*;

public class Main1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();
        int count = 0;

        //1 부터 99까지는 전부다 등차 수열이다
        if (N < 100){
            count = N;
        }
        else{
            if (N == 1000){ //1000일 경우 아해의 first,second,third를 구하는데 문제가 생김
                N = 999;
            }
            count = 99;
            for(int i = 100; i <= N; i++){
                int first,second,third;
                first = i / 100;
                second = (i  % 100) / 10;
                third = (i % 100) % 10;
                if ((second - first) == (third - second)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
