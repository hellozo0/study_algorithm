
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //기본이 오름차순
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>(); // 오름차순 -39 , -37
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 11 , 2

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if (num < 0) minusPQ.add(num);
            else plusPQ.add(num);
        }

        int count = M-1;

        int flag = 0;
        if (minusPQ.isEmpty()){ flag = 1; }
        if (plusPQ.isEmpty()) { flag = 2; }
        if (minusPQ.isEmpty() && plusPQ.isEmpty()) { flag = 3;}


        //제일 큰쪽으로 1번만 answer++
        if(flag == 0 && -minusPQ.peek() > plusPQ.peek()){
            answer += -minusPQ.poll();

            //M - 1개 만큼 poll
            while (count >0 && !minusPQ.isEmpty()) {
                minusPQ.poll();
                count--;
            }

        } else if (flag == 0 && -minusPQ.peek() < plusPQ.peek()) {
            answer += plusPQ.poll();
            //M - 1개 만큼 poll
            while (count >0 && !plusPQ.isEmpty()) {
                plusPQ.poll();
                count--;
            }
        } else if (flag == 1) {
            answer += plusPQ.poll();
            //M - 1개 만큼 poll
            while (count >0 && !plusPQ.isEmpty()) {
                plusPQ.poll();
                count--;
            }
        } else if (flag == 2) {
            answer += -minusPQ.poll();

            //M - 1개 만큼 poll
            while (count >0 && !minusPQ.isEmpty()) {
                minusPQ.poll();
                count--;
            }

        } else if (flag == 3) {
            System.out.println(0);
            return;
        }

        count = 0;
        while (!minusPQ.isEmpty()){
            if( count % M == 0) {
                answer += (-minusPQ.poll()) * 2; //29
            } else {
                minusPQ.poll(); //28
            }
            count++; // --> 2
        }

        count = 0;
        while (!plusPQ.isEmpty()){
            if( count % M == 0) {
                answer += plusPQ.poll() * 2; //29
            } else {
                plusPQ.poll(); //28
            }
            count++; // --> 2
        }

        System.out.println(answer);
    }

}
