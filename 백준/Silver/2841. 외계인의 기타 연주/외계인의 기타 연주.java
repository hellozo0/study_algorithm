import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            while (!stack[number].isEmpty() && stack[number].peek() > flat) {
                stack[number].pop();
                answer++;
            }
            if (stack[number].isEmpty() || stack[number].peek() < flat) {
                stack[number].push(flat);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
