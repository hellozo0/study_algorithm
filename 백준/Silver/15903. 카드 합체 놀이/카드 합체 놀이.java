import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        var pq = new PriorityQueue<>(Comparator.comparingLong((Long i)-> i));
        for(int i = 0; i < n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.add(num1+num2);
            pq.add(num1+num2);
        }

        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}
