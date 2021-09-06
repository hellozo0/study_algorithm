package Bronze;
import java.util.*;

public class Main11720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String letter = sc.next();
        sc.close();
        
        int sum = 0;
        for (int i = 0; i < N; i++){
            sum += letter.charAt(i)-'0';
        }

        System.out.println(sum);
    }
}
