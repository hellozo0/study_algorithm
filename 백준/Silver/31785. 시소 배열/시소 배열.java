
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        //데크,
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());

            if(question == 1){
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (question == 2 && deque.size() > 1){
                //여기에서 이제 절반 나눠서 계산해야함
                int dequeSize = deque.size(); //3이라고 치자
                int halfSize = dequeSize/2;

                int[] frontArray = new int[halfSize];
                int[] backArray = new int[dequeSize-halfSize];
                int front = 0;
                int back = 0;
                for(int j = 0; j < halfSize; j++){
                    frontArray[j] = deque.pollFirst();
                    front += frontArray[j];
                }

                for(int j = 0; j < dequeSize-halfSize; j++){
                    backArray[j] = deque.pollFirst();
                    back += backArray[j];
                }

                if(front <= back){
                    System.out.println(front);
                    for(int k = 0; k < dequeSize-halfSize; k++){
                        deque.addLast(backArray[k]);
                    }
                } else {
                    System.out.println(back);
                    for(int k = 0; k < halfSize; k++){
                        deque.addLast(frontArray[k]);
                    }
                }

            }
        }
        while (!deque.isEmpty()){
            System.out.print(deque.pollFirst() + " ");
        }
    }
}
