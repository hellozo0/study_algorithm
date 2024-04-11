
/*
위상 정렬(Topological Sort)은 노드 A에서 노드 B로 가는 간선이 있다면 노드 A를 노드 B보다 앞으로 하여 정렬하는 것을 의미한다.
그리고, 위상 정렬이 가능한 그래프는 사이클이 없는 방향 그래프(DAG)

위상 정렬 알고리즘은 모든 노드와 모든 간선을 한 번씩 살펴보므로 시간 복잡도는 O(노드개수 + 간선개수)이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static ArrayList<ArrayList<Integer>> child;
    static int[] weight, complete, indeg;

    public static void main(String[] args) throws IOException {

        // (1) 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        // (2) 입력 받음
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 각 건물의 건설 시간 저장
            weight = new int[N + 1];
            // 각 건물의 건설 완료 시간 저장
            complete = new int[N + 1];
            // 각 건물의 in-degree 저장
            indeg = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            child = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                child.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                child.get(c).add(p);
                indeg[p]++;
            }

            // 최종적으로 건설할 건물 번호
            int building = Integer.parseInt(br.readLine());
            topologicalSort();
            System.out.println(complete[building]);

        }
    }

    // (3) 위상 정렬
    static void topologicalSort() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                // 시작 지점일 경우, 자신의 건설 시간을 넣어준다.
                complete[i] = weight[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : child.get(x)) {
                indeg[y]--;
                if(indeg[y] == 0)
                    queue.add(y);
                // x와 y를 끊을 때, 기존에 y에 계산되어 있던 건설 시간과
                // 이전 x의 건설 시간에 y 자신만의 건설 시간을 더한 값 중 더 큰 값을
                // y의 최종 건설 시간에 넣어준다.
                complete[y] = Math.max(complete[y], complete[x] + weight[y] );
            }
        }
    }
}
