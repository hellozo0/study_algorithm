
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split("-");
        int answer = Integer.MAX_VALUE; // 이렇게 첫번쨰 요소 처리하는 방법 알게 되었다..!!! 굳..... 기억해두고 써먹어야지

        for(int i = 0; i < num.length; i++) {
            String[] num2 = num[i].split("\\+");
            int sum = 0;

            for(int j = 0; j < num2.length; j++) {
                sum += Integer.parseInt(num2[j]);
            }

            if(answer == Integer.MAX_VALUE){
                answer = sum;
            } else {
                answer -= sum;
            }

        }

        System.out.println(answer);

    }
}
