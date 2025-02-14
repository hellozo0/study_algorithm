import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Time> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Time(Integer.parseInt(st.nextToken()), true));
            pq.add(new Time(Integer.parseInt(st.nextToken()), false));
        }

        int cnt = 0; 
        int answer = 0;

        while (!pq.isEmpty()) {
            Time t = pq.poll();
            if (t.isStart) {
                cnt++;
                answer = Math.max(cnt, answer);
            } else {
                cnt--;
            }
        }
        System.out.println(answer);
    }

    static class Time implements Comparable<Time>{
        int time;
        boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }
}