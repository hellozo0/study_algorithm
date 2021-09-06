package Bronze;
import java.util.*;

public class Main5622 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0;
        sc.close();

        //1 -> 2초 
        for(int i = 0; i < str.length();i++){
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'C'){
                count += 3;
            }
            else if (str.charAt(i) >= 'D' && str.charAt(i) <= 'F'){
                count += 4;
            }
            else if (str.charAt(i) >= 'G' && str.charAt(i) <= 'I'){
                count += 5;
            }
            else if (str.charAt(i) >= 'J' && str.charAt(i) <= 'L'){
                count += 6;
            }
            else if (str.charAt(i) >= 'M' && str.charAt(i) <= 'O'){
                count += 7;
            }
            else if (str.charAt(i) >= 'P' && str.charAt(i) <= 'S'){
                count += 8;
            }
            else if (str.charAt(i) >= 'T' && str.charAt(i) <= 'V'){
                count += 9;
            }
            else if (str.charAt(i) >= 'W' && str.charAt(i) <= 'Z'){
                count += 10;
            }
        }
        System.out.println(count);
    }
}
