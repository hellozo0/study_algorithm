package Bronze;
import java.util.*;

public class Main2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // 겹 수(최소 루트)
		int range = 2;	// 범위 (최솟값 기준) 

        if (N == 1){
            System.out.println(1);
        }
        else {
            while(range <= N){
                range = range + (6 * count);
				count++;
            }
            System.out.println(count);
        }
    }
}
