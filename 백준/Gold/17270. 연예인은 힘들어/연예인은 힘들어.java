import java.util.*;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 노드 개수
        int m = sc.nextInt();  // 간선 개수

        // 테이블 초기화 (최대 거리로 설정)
        int[][] table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(table[i], INF);
            table[i][i] = 0;
        }

        // 간선 입력받기
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            table[v1][v2] = Math.min(table[v1][v2], cost);
            table[v2][v1] = Math.min(table[v2][v1], cost);
        }

        // 플로이드 워셜 알고리즘 (모든 노드 간 최단 거리 계산)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (table[i][j] > table[i][k] + table[k][j]) {
                        table[i][j] = table[i][k] + table[k][j];
                    }
                }
            }
        }

        // 지헌과 성하의 위치 입력받기
        int pointJ = sc.nextInt();
        int pointS = sc.nextInt();

        // 최소 거리 찾기
        int minDistance = INF;
        for (int destination = 1; destination <= n; destination++) {
            if (destination == pointJ || destination == pointS) continue;
            if (table[pointJ][destination] == INF || table[pointS][destination] == INF) continue;
            if (table[pointJ][destination] + table[pointS][destination] > minDistance) continue;
            minDistance = table[pointJ][destination] + table[pointS][destination];
        }

        // 지헌이의 최단 거리 비교
        int minDistanceOfJihyeon = INF;
        int answerIdx = -1;

        for (int destination = 1; destination <= n; destination++) {
            if (destination == pointJ || destination == pointS) continue;
            if (table[pointJ][destination] + table[pointS][destination] != minDistance) continue;
            if (table[pointJ][destination] > table[pointS][destination]) continue;
            if (table[pointJ][destination] > minDistanceOfJihyeon) continue;

            minDistanceOfJihyeon = table[pointJ][destination];
            answerIdx = destination;
        }

        // 결과 출력
        System.out.println(answerIdx);
    }
}