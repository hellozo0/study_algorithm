import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j = 0; j < k; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            System.out.println(solution(pq));
        }
    }

    private static long solution(PriorityQueue<Long> pq){
        long answer = 0;
        while (true){
            if(pq.size() == 1) break;

            long num1 = pq.poll();
            long num2 = pq.poll();
            answer += num1 + num2;
            pq.add(num1 + num2);
        }
        return answer;
    }
}
