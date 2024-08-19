
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        answer = -1;
        int count = 1;

        dfs(start, target, count);
        System.out.println(answer);
    }

    public static void dfs(long start, long target, int count) {
        if( start > target) return;
        if (start == target) {
            answer = count;
            return;
        }

        dfs(start *2, target, count + 1);
        dfs((start *10)+1, target, count + 1);

    }
}
