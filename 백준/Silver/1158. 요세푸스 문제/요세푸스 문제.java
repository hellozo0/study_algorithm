
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){ //반복문 7번
            queue.add(i);
        }

        System.out.print("<");
//        System.out.print(queue.poll() + ", "); //3이 나옴

        while(!queue.isEmpty()){
            //3번 반복
            for(int i = 0; i <K-1; i++){
                queue.add(queue.poll());
            }

            if(queue.size() == 1){
                System.out.print(queue.poll() + ">");
            } else {
                System.out.print(queue.poll() + ", ");
            }
        }
    }
}
