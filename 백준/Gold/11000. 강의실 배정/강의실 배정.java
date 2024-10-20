
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] classes = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classes, Comparator.comparingInt((int[] o1) -> o1[0])
                .thenComparingInt(o1 -> o1[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0][1]);

        //이부분 로직 --> 이런거 많이 풀어 봐야 할듯 
        for(int i = 1; i < N; i++){
            if(!pq.isEmpty() && pq.peek() <= classes[i][0]){ // 3 ,, 2(x)  --> 3  ,, 3(o)
                pq.poll();
            }
            pq.add(classes[i][1]); //3,4 들어가 있고
        }
        System.out.print(pq.size());

    }
}
