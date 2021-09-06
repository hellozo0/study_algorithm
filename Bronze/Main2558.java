package Bronze;
import java.util.*;


public class Main2558 {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a, b, a100,a10,a1,b100,b10,b1;
		a = sc.nextInt();
		b = sc.nextInt();
        	a100 = a / 100;
        	a10 = (a % 100 ) / 10;
        	a1 =  (a % 100) % 10;
        	b100 = b / 100;
        	b10 = (b % 100 ) / 10;
        	b1 =  (b % 100) % 10;
		System.out.println(a * b1);
        	System.out.println(a * b10);
        	System.out.println(a * b100);
        	System.out.println(a * b);
	}
}
