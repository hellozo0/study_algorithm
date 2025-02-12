import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Beer {
    int prefer, alcohol;

    public Beer(int prefer, int alcohol) {
        this.prefer = prefer;
        this.alcohol = alcohol;
    }
}
public class Main {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> prefers = new PriorityQueue<>();
        List<Beer> beers = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            beers.add(new Beer(p, a));
        }
        beers.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if (o1.alcohol == o2.alcohol) {
                    return o2.prefer - o1.prefer;
                }
                return o1.alcohol - o2.alcohol;
            }
        });

        int total = 0;
        int answer = -1;
        for (Beer beer : beers) {
            prefers.add(beer.prefer);
            total += beer.prefer;

            if (prefers.size() > N) {
                total -= prefers.poll();
            }
            if (prefers.size() == N && total >= M) {
                answer = beer.alcohol;
                break;
            }
        }
        System.out.print(answer);
    }
}