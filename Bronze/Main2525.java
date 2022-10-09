package Bronze;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// public class Main2525 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st;
//         st = new StringTokenizer(br.readLine(), " ");

//         int H = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         int plus = Integer.parseInt(br.readLine());
//         M += plus;

//         if (M >= 60) {
//             H += M/60;
//             M = M % 60;
//         }
//         if (H > 23) {
//             H -= 24;
//         }
//         System.out.println(H + " " + M);

//     }
// }


//Selection sort
public class Main2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int plus = Integer.parseInt(br.readLine());
        M += plus;

        if (M >= 60) {
            H += M/60;
            M = M % 60;
        }
        if (H > 23) {
            H -= 24;
        }
        System.out.println(H + " " + M);

    }
}
