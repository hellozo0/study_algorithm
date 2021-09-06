package Bronze;
import java.util.*;


public class Main8958 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        String enter1 = sc.nextLine();
        int count = 0,sum = 0;
        

        for(int i = 0; i <tc; i++){
            sum = 0;
            count = 0;
            String str = sc.nextLine();
            
            for(int j = 0; j < str.length(); j++){
                if (str.charAt(j) == 'O'){
                    count++;
                    sum += count;
                }
                else if (str.charAt(j) == 'X'){
                    count = 0;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }   
}
