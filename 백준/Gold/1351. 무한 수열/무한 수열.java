
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Long,Long> map;
    static long answer;
    static long P;
    static long Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        //예외 Case
        if(N == 0) {
            System.out.print(1);
            return;
        }

        long front = N / P;
        long back = N / Q;
        long max = Math.max(front, back);

        map = new HashMap<>();

        map.put(0L,1L);
        answer = 0L;

        // for(long i = 1; i <= max; i++){
        //     long a = (i / P);
        //     long b = (i / Q);
        //
        //     map.put(i,map.get(a) + map.get(b));
        // }
        answer += dfs(front);
        answer += dfs(back);

        System.out.print(answer);
    }

    private static long dfs(long num){

        if( num == 0 ) return 1;
        if(map.containsKey(num)) return map.get(num);

        map.put(num, dfs(num/P) + dfs(num/Q));
        return map.get(num);
    }
}