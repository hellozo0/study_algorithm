package org.example.hyundai.autoever25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제 설명 (양궁 대회)
 * 1. 과녁의 크기는 NxN
 * 2. 과녁에 정수값이 적혀 있음
 * 3. K개의 화살이 있다. (굵기는 1 ~ K로)
 * 4. 굵기(1~K)순으로 B[i]배열 만큼의 힘이 필요하다.
 * 5. 최소한의 힘으로 P점을 맞추고 싶다
 * 6. B[i] 배열에 있는 화살들은 굵기 별로 1개 씩만 쏠 수 있다. (그냥 굵기 별로 1개씩만 쏠 수 있음)
 * 7. 만약 못구한다면 -1 출력
 * 8. 그리고 해당 굵기는 |x1-x2| + |y1-y2| 의 미만만큼의 범위의 점수를 총 합해서 획득한다.
 *   예를 들어 [1,1,1][1,1,1][1,1,3]에서 3행 3열에 2굵기의 화살을 쏜다면 5점을 획득하는 것이다. 2행 2열에 2굵기의 화살을 쏜다면 5점을 얻는 것이다.
 *
 * (입력조건)
 * 1. 1 <= N <= 10
 * 2. 1 <= K <= N
 * 3. 1 <= P <= 10,000
 * 4. 1<= 격자 점수 <= 100
 * 5. 1 <= B[i] <= 100,000
 *
 * (입력)
 * - N K P
 * - NxN에 적힌 점수들
 * - 힘 B배열 값들
 *
 * (예시)
 * N = 3, K = 2, P = 8
 * 1 1 1
 * 1 1 1
 * 1 1 3
 * B[] = {1,2}
 *
 * => 3
 * ----------------------
 * N = 4, K = 4, P = 319
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 1 100
 * 1 1 1 1
 * B[] = {1,2,4,6}   --> ✅ 부연 설명을 하자면 처음에 여기를 잘못이해했었는데, 굵기1,2,3,4 순으로 힘이 1,2,4,6이 필요하다는 말이다.
 *
 * => 11
 * ----------------------
 * N = 3, K = 2, P = 15
 * 1 3 1
 * 3 1 3
 * 1 3 1
 * 1 2
 *
 * => -1
 *
 * **/

/*
3 2 8
1 1 1
1 1 1
1 1 3
1 2
----------------------
4 4 319
1 1 1 1
1 1 1 1
1 1 1 100
1 1 1 1
1 2 4 6
-----------------------
3 2 15
1 3 1
3 1 3
1 3 1
1 2
*/
 /**
  * 🚀 내가 풀었던 방법
  * 1. 굵기별로 범위값을 다 조절해서 총 1,2,3.. K 개의 굵기마다의 나올 수 있는 점수 총 합을 각각 구한다.
  * 2. 그 점수 값들은 중복을 제거해서 굵기 별로 분리해서 array를 만든다.
  * 3. 어차피 굵기 1에서 나온 것 들 중에 1개의 점수만 쓸 수 있기 때문에 ..
  * 4. 근데 마지막 쯤에 되서 그 최소하의 조합을 어떻게 조합할지 몰라서 마지막 쯔음에 방향을 놓쳤다.
  * ==> 마지막에 그냥 모든 조합을 다 구해서 DP로 풀까도 생각했음
 **/

 /**
  * GPT
  * 2️⃣ 효율적인 해결 방법
  *
  * 내가 선택할 방법은 BFS + 백트래킹 + DP(메모이제이션) 조합입니다.
  *
  * ✅ Step 1: 굵기별 가능한 점수 계산 (BFS 활용)
  * 	•	각 (x, y) 위치에서 B[i] 범위 내 점수를 BFS로 계산.
  * 	•	굵기별(B[i]) 가능한 점수 합 리스트(scores[i]) 저장.
  * 	•	중복 점수를 제거하여 각 굵기별 유효한 점수 조합을 만듦.
  *
  * ✅ Step 2: 백트래킹으로 최소 힘 탐색
  * 	•	각 굵기에서 하나씩만 선택할 수 있도록 백트래킹을 활용.
  * 	•	현재까지 사용한 힘이 최소 힘(minPower)보다 크다면 가지치기(Pruning).
  *
  * ✅ Step 3: DP를 활용한 점수 조합 최적화
  * 	•	중간 계산 결과(점수 합, 사용한 힘)를 저장하여 중복 연산을 피함.
  *
  * 3️⃣ 최적화된 풀이 방식
  * 	1.	가능한 점수 계산 (BFS 활용)
  * 	•	각 (x, y)에서 B[i] 범위 내의 모든 점수를 합산하여 scores[i] 리스트에 저장.
  * 	•	같은 점수가 중복되지 않도록 Set을 활용하여 저장.
  * 	2.	최소 힘 찾기 (백트래킹)
  * 	•	backtrack(현재 사용한 힘, 현재 점수 합, 사용한 화살 개수)
  * 	•	현재까지 점수 합이 P를 초과하면 중단 (가지치기)
  * 	•	현재까지 사용한 힘이 minPower보다 크면 중단 (Pruning)
  * 	3.	DP(메모이제이션)
  * 	•	dp[currentScore] = 최소 힘을 저장하여 같은 점수 합을 중복 탐색하지 않도록 최적화.
 **/

public class Prob2 {
	 static int N, K, P;
	 static int[][] board;
	 static int[] B;
	 static List<Set<Integer>> scores; // 각 굵기별 가능한 점수 조합
	 static int minPower = Integer.MAX_VALUE;
	 static Map<Integer, Integer> dp = new HashMap<>(); // 점수 합 -> 최소 힘 메모이제이션

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());

		 N = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(st.nextToken());
		 P = Integer.parseInt(st.nextToken());

		 board = new int[N][N];
		 for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < N; j++) {
				 board[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }

		 B = new int[K];
		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < K; i++) {
			 B[i] = Integer.parseInt(st.nextToken());
		 }

		 // 1. 각 굵기별 가능한 점수 조합 계산
		 scores = new ArrayList<>();
		 for (int i = 0; i < K; i++) {
			 scores.add(new HashSet<>());
		 }

		 for (int g = 0; g < K; g++) {
			 for (int i = 0; i < N; i++) {
				 for (int j = 0; j < N; j++) {
					 int sum = bfs(i, j, B[g]); // 특정 좌표에서 범위 내 점수 합 계산
					 scores.get(g).add(sum);
				 }
			 }
		 }

		 // 2. 백트래킹으로 최소 힘 찾기
		 backtrack(0, 0, 0);

		 // 3. 결과 출력
		 System.out.println(minPower == Integer.MAX_VALUE ? -1 : minPower);
	 }

	 // BFS를 사용하여 (x, y)에서 B[g] 범위 내 점수 합 계산
	 private static int bfs(int x, int y, int range) {
		 boolean[][] visited = new boolean[N][N];
		 Queue<int[]> queue = new LinkedList<>();
		 queue.add(new int[]{x, y});
		 visited[x][y] = true;
		 int sum = 0;

		 while (!queue.isEmpty()) {
			 int[] cur = queue.poll();
			 int cx = cur[0], cy = cur[1];
			 sum += board[cx][cy];

			 // 상하좌우 탐색 ==> 이거 대각선도 퐘되는 경우도 있는데?
			 int[] dx = {-1, 1, 0, 0};
			 int[] dy = {0, 0, -1, 1};
			 for (int d = 0; d < 4; d++) {
				 int nx = cx + dx[d], ny = cy + dy[d];
				 if (nx >= 0 && ny >= 0 && nx < N && ny < N &&
					 !visited[nx][ny] && (Math.abs(nx - x) + Math.abs(ny - y) < range)) { // "미만(<)" 조건 수정
					 queue.add(new int[]{nx, ny});
					 visited[nx][ny] = true;
				 }
			 }
		 }
		 return sum;
	 }

	 // 백트래킹으로 최소 힘을 찾음  ==> 근데 완탐으로 해야할거 같은데 ? (안 고르거나 고르거나로..?
	 private static void backtrack(int depth, int scoreSum, int powerSum) {

		 //P는 내 타겟이고
		 //scoreSum은 가능한 점수들 누적합
		 //powerSum은 그래서 힘이 얼만큼 들었나

		 if (scoreSum >= P) {
			 // 점수에 딱 맞으면 minPower가 정해짐(누적 개수)
			 if (scoreSum == P) {
				 minPower = Math.min(minPower, powerSum);
			 }
			 return;
		 }

		 //만약 minPower 넘어갔으면 커팅(프루닝)
		 if (powerSum >= minPower) return;

		 //만약 <점수합, 최소힘>
		 // 해당 점수합을 가지고 있고, 그 값이 지금 구한거보다 적으면 패스(값을 바꿀 필요가 없잖아)
		 if (dp.containsKey(scoreSum) && dp.get(scoreSum) <= powerSum) return;
		 // 해당 점수까지의 결과가 없으니까 dp에 넣음
		 dp.put(scoreSum, powerSum);

		 //깊이가 K를 넘어가면(힘의 개수) 그러면 어차피 탐색 안된다.
		 if (depth >= K) return;

		 // 현재 굵기의 화살을 사용하지 않는 경우 (즉, 그냥 넘어가는 경우)
		 backtrack(depth + 1, scoreSum, powerSum);

		 //해당 힘에서 고를 수 있는 거를 하나 고르고 시작한다.
		 for (int score : scores.get(depth)) {
			 backtrack(depth + 1, scoreSum + score, powerSum + B[depth]);
		 }
	 }
}
