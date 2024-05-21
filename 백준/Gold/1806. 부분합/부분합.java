

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] num = new int[n+1];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (start <= end && end <= n){
            if(sum < target) {
                sum += num[end++];
            } else if (sum >= target){
                len = Math.min(len, end - start);
                sum -= num[start++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE? 0 : len);
    }
}
