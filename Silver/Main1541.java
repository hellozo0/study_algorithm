package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;//초기상태 확인용
        String[] sub = br.readLine().split("-");

        for (int i = 0; i< sub.length; i++) {
            int temp = 0;

            String[] add = sub[i].split("\\+");
            for(int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            //첫번째 값일 경우 temp 값이 첫번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
    
}
