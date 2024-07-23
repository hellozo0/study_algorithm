
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPQ  = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > 1 ) plusPQ.add(temp);
            else if (temp < 0 ) minusPQ.add(temp);
            else if (temp == 1) one++;
            else zero++;
        }

        while (plusPQ.size() > 1) {
            int first = plusPQ.poll();
            int second = plusPQ.poll();

            answer += first * second;
        }

        if(!plusPQ.isEmpty())  answer += plusPQ.poll();

        while (minusPQ.size() > 1) {
            int first = minusPQ.poll();
            int second = minusPQ.poll();

            answer += first * second;
        }

        if(!minusPQ.isEmpty()) {
            if( zero == 0) answer += minusPQ.poll();
        }

        answer += one;
        System.out.println(answer);
    }
}
