
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
        int n = Integer.parseInt(st.nextToken()); //트럭의 수
        int w = Integer.parseInt(st.nextToken()); // w
        int l = Integer.parseInt(st.nextToken()); // l (최대하중)

        st = new StringTokenizer(br.readLine());

        Queue<Integer> trucks = new LinkedList<>();
        for(int i = 0; i < n; i++){
            trucks.add(Integer.parseInt(st.nextToken())); // 7 4 5 6
        }

        Queue<Integer> queue = new LinkedList();
        int answer = 0; //정답
        int weight = 0;
        int index = 0;

        for(int i = 0; i < w; i++){
            queue.add(0);
        }

        while (!queue.isEmpty()){
            answer++;
            weight -= queue.poll();

            if(!trucks.isEmpty()){
                if( trucks.peek() + weight <= l){
                    weight += trucks.peek();
                    queue.add(trucks.poll());
                } else {
                    queue.add(0);
                }
            }
        }
        System.out.println(answer);
    }
}
