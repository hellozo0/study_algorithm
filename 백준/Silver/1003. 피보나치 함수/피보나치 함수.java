import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[][] arrayFibo = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //호출횟수 ( 0일때 0호출 횟수 )
        arrayFibo[0][0] = 1;
        arrayFibo[0][1] = 0;
        arrayFibo[1][0] = 0;
        arrayFibo[1][1] = 1;

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            checkFibo(N);
            System.out.println(arrayFibo[N][0] + " " + arrayFibo[N][1]);
        }

    }

    public static Integer[] checkFibo(int n){

        if(arrayFibo[n][0] == null || arrayFibo[n][1] == null){
            arrayFibo[n][0] = checkFibo(n-1)[0] + checkFibo(n-2)[0];
            arrayFibo[n][1] = checkFibo(n-1)[1] + checkFibo(n-2)[1];
        }

        return arrayFibo[n];
    }

}
