package 백준.Bronze;
import java.util.*;

public class Main2577{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int d = (sc.nextInt() * sc.nextInt() * sc.nextInt());
        sc.close();
        String str = Integer.toString(d); //형변환

        for (int i = 0; i <10; i++){
            int count = 0;
            for(int j = 0; j< str.length();j++){ //문자의 개수만큼
                if((str.charAt(j)-'0') == i){ 
                    count++; 
                }
            }
            System.out.println(count);
        }    
    }   
}