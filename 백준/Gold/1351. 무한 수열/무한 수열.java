
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static int P,Q;
    static  HashMap<Long,Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        //N,P,Q 값이 엄청 크다. DP 메모리 제이션 불가  --> Hash Map
        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(recursion(N));
    }

    private static long recursion(long N) {
        if( N == 0 ) return 1;
        if(map.containsKey(N)) return  map.get(N);

        map.put(N, recursion((N/P)) + recursion((N/Q)));
        return map.get(N);
    }

}
