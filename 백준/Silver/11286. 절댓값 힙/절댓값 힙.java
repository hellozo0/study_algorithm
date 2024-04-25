
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if(first == second){
                return o1 > o2? 1 : -1;
            } else {
                return first - second; // 절대값 기준 정렬
            }
        });

        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if( pq.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}
