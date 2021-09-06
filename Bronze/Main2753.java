package Bronze;
import java.util.*;

public class Main2753 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();
        if ((a % 4 == 0) && ((a % 100 != 00) || (a % 400 == 0 ))){
            System.out.println("1");
        }
        else{
            System.out.println("0");

        }
    } 
}
