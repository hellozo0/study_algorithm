package 백준.Bronze;
import java.util.*;


public class Main1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim(); //한 줄 다 받기 (공백 있는거 받는 경우는 nextLine)
        sc.close();
        
        if (str.isEmpty()) { //비어 있다면
            System.out.println(0);
        } else {
            System.out.println(str.split(" ").length);
        }
        
    }
}
