import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] number = new int[n];
            for(int j = 0; j < n; j++){
                number[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(number,k));
        }
    }

    private static int solution(int[] number, int k){
        int answer = 0;
        int minDistance = Integer.MAX_VALUE;
        int start = 0;
        int last = number.length-1;
        Arrays.sort(number);

        while(start < last){
            int sum = number[start] + number[last];
            int distance = Math.abs(sum-k);

            //이아래 부분부터 로직 하나로 묶으려다가 뇌도 묶임.... 어떻게 구현하면 좋을지 단순히 생각해볼것
            if(minDistance >= distance) {
                if(minDistance > distance) answer = 0;
                minDistance = distance;
                answer++;
            }

            if(sum >= k) last--;
            else start++;
        }
        return answer;
    }
}
