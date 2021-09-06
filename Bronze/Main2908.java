package Bronze;
import java.util.*;


public class Main2908 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int f,s,t = 0;
        sc.close();

        f = num1 / 100;
        s = num1 % 100 / 10;
        t = num1  % 100 % 10;
        num1 = t * 100 + s * 10 + f ;

        f = num2 / 100;
        s = num2 % 100 / 10;
        t = num2  % 100 % 10;
        num2 = t * 100 + s * 10 + f ;

        if (num1 > num2){
            System.out.println(num1);
        }
        else{
            System.out.println(num2);
        }
    }
}
