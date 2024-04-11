package 백준.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2599 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int box[][] = new int[3][2];
        boolean check = true;

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            box[i][0] = Integer.parseInt(st.nextToken());
            box[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= box[0][0]; i++){
            int result[][] = new int[3][2];
            result[0][0] = i; // 그냥 수식으로 구하는 문제 였다...
            result[0][1] = box[0][0] - i;
            result[1][1] = box[2][1] - result[0][1];
            result[1][0] = box[1][0] - result[1][1];
            result[2][0] = box[0][1] - result[1][0];
            result[2][1] = box[2][0] - result[2][0];

            if (result[0][0] >= 0 && result[0][1] >= 0 && result[1][0] >= 0 && result[1][1] >= 0 && result[2][0] >= 0 && result[2][1] >= 0){
                System.out.println(1);
                System.out.println(result[0][0] + " " + result[0][1]);
                System.out.println(result[1][0] + " " + result[1][1]);
                System.out.println(result[2][0] + " " + result[2][1]);
                check = false;
                break;
            }
        }

        if(check) {
            System.out.println(0);
        }

    }
}
