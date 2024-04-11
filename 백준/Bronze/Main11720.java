package 백준.Bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// public class Main11720 {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
        
//         int N = sc.nextInt();
//         String letter = sc.next();
//         sc.close();
        
//         int sum = 0;
//         for (int i = 0; i < N; i++){
//             sum += letter.charAt(i)-'0';
//         }

//         System.out.println(sum);
//     }
// }


// public class Main11720 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt();

//         String sNum = sc.next();
//         char[] cNum = sNum.toCharArray();

//         int sum = 0;
//         for (int i = 0; i < N; i++) {
//             sum += cNum[i] - '0';
//         }

//         System.out.println(sum);

//     }
// }

public class Main11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum = 0;

        for(byte value : br.readLine().getBytes()){
            sum += (value - '0');
        }

        System.out.println(sum);

    }
}