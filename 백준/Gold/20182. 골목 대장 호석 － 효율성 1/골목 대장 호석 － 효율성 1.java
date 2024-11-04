import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int answer;
    private static int money;
    private static ArrayList<Edge>[] list;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        // 자료구조 선언 및 초기화
        list = new ArrayList[N + 1];
        distance = new int[N + 1];
        answer = 10001;

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보 입력 (양방향 추가)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, cost));
            list[v].add(new Edge(u, cost));
        }

        // 이진 탐색을 통해 최소의 최대 요금 찾기
        binSearch(start, target);

        // 결과 출력
        System.out.println(answer == 10001 ? -1 : answer);
    }

    private static void binSearch(int start, int target) {
        int low = 1;
        int high = 10000;  // 문제 조건에 맞게 upper bound 수정
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            // 다익스트라로 검사
            if (dijkstra(start, target, mid)) {
                answer = mid;    // 가능한 최대 요금이므로 answer 갱신
                high = mid - 1;  // 더 작은 최대 요금으로 탐색
            } else {
                low = mid + 1;   // 더 큰 최대 요금으로 탐색
            }
        }
    }

    private static boolean dijkstra(int start, int target, int maxCost) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.vertex == target && distance[target] <= money) {
                return true;
            }

            if (distance[current.vertex] < current.value) continue;

            for (Edge next : list[current.vertex]) {
                if (next.value > maxCost) continue;  // 최대 요금을 넘는 간선 제외

                int newDist = distance[current.vertex] + next.value;
                if (newDist < distance[next.vertex]) {
                    distance[next.vertex] = newDist;
                    pq.add(new Edge(next.vertex, newDist));
                }
            }
        }
        return distance[target] <= money;
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}