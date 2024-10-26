
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static int k;
    static char[] relation;
    static boolean[] visited;
    static List<String> possible = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        relation = new char[k];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            relation[i] = st.nextToken().charAt(0);
        }

        // 0부터 9까지 숫자를 시도
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(1, String.valueOf(i));  //0번부터 츄라이
            visited[i] = false;
        }

        possible.sort(Comparator.naturalOrder());

        System.out.println(possible.get(possible.size() - 1));
        System.out.println(possible.get(0));
    }

    private static void dfs(int count, String num) {
        if (count == k + 1) { // 숫자가 k+1개가 되면 종료
            possible.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }

            //이전 숫자와의 관계를 검사
            if (check(num.charAt(count - 1) - '0', i, relation[count - 1])) {
                visited[i] = true;
                dfs(count + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int x, int y, char relation) {
        if (relation == '<') return x < y;
        else return x > y;
    }
}