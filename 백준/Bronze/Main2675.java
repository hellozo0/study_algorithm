package 백준.Bronze;
import java.util.*;

public class Main2675 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i = 0; i < tc; i++){
            int rc = sc.nextInt();
            String s1 = sc.next();
            for(int j = 0; j < s1.length(); j++){
                char s2 = s1.charAt(j);
                for(int k = 0; k < rc; k++){
                    System.out.print(s2);
                }
            }
            System.out.println("");
        }
    }
}
