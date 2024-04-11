package 백준.Bronze;
import java.util.*;


public class Main10430 {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a, b,c;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
        	System.out.println((a+b)%c);
        	System.out.println(((a%c)+ (b%c))%c);
        	System.out.println((a*b)%c);
        	System.out.println(((a%c) * (b%c))%c);
	}
}
