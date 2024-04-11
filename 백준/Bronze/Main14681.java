package 백준.Bronze;
import java.util.*;


public class Main14681 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a,b;
        a = sc.nextInt();
        b = sc.nextInt();
        if (a > 0 && b > 0){
            System.out.println("1");
        }
        else if (a > 0 && b < 0){
            System.out.println("4");
        }
        else if (a < 0 && b > 0){
            System.out.println("2");
        }
        else if (a < 0 && b < 0){
            System.out.println("3");
        }
    }   
}
