
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.sun.jdi.IntegerType;

public class Main {
    public static void main(String[] args) throws IOException {
        // write code...ㅎㅎㅎㅎ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        //누적합
        for(int i = 1; i < N+1; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        //0,   2,0,2,0

        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0,1L); //왜 1로 세팅하지??? 딱 맞는거 있다는 전제하에

        //sum[i] - sum[j-1] = k 인걸 찾기 j ~ i까지의 합
        //sum[i] - k = sum[j-1]; ->
        long answer = 0;
        for(int i = 1; i < N+1; i++){
            //정답이 있다면 값을 가져온다 -> 없다면 0
            answer += map.getOrDefault(sum[i] - K, 0L);
            //해당 누적 값에 값을 가져와서+1한다.
            map.put(sum[i], map.getOrDefault(sum[i],0L)+1);
        }

        System.out.println(answer);

    }
}