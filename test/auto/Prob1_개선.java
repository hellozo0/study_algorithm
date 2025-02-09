package org.example.hyundai.autoever25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 독립점
 * (조건)
 * - 한 정점(N)당 최대 2간선(M)을 가지고 있다. (0,1,2개의 간선을 가질 수 있다)
 * - 서로 연결되지 않고 독립된 점들의 최대 개수를 출력해라
 * (입력)
 * - (3 <= N <= 100,000), (0<=M<=N)
 * (예시)
 * N = 7, M = 6
 * (1,2)(2,3)(1,3)(4,5)(5,6)(6,7) 의 경우에는 3의 결과
 * => 1/2/3 중에 1개, (4와 6) 이런식으로 총 3개의 독립점을 가질 수 있음
 *
 * (예시)
 * N = 6, M = 4
 * (1,2)(2,3)(3,4)(4,5)
 * => 1,3,5,6 해서 총 4개를 가질 수 있음
 *
 * (나의 문제 접근 방식)
 * 일단은 N개의 노드를 하나씩 다 탐색을 한다.
 * 이어져 있는 애들으 BFS로 탐색을 하면서 vissited를 컬러로 표시했다. Red(1)랑 Black(-1)로.. 그리고 각 색깔 별로 개수를 누적합했다.
 * 그리고 만약 BFS를 하면서 이미 방무했던거를 또 방문ㄴ하는 것은 컬러가 겹치기 때문에 -1을 해준다.
 *
 * (의문점)
 * 테스트코드는 통과했는ㄷ네 사실 사이클이 있을 경우에 대해 완벽한 분별을 못했을 것이다.
 * **/

/**
 * ✅ 개선 방향
 * 	1.	홀수 길이 사이클이 존재하는 경우에도 가능한 독립점을 찾아야 함
 * 	•	특정 서브그래프에서 서로 연결되지 않은 최대 개수의 점을 선택하는 문제로 바뀜.
 * 	•	이분 그래프 여부와 관계없이, 각 연결 요소에서 가능한 최대 독립점을 선택해야 함.
 * 	2.	홀수 길이 사이클이 있는 경우의 독립점 선택 방법
 * 	•	이분 그래프인 경우: 색깔 그룹별 개수를 세고 max(빨간색 그룹, 검은색 그룹) 선택
 * 	•	사이클이 있는 경우:
 * 	•	사이클이 짝수면 기존 방식 사용 가능.
 * 	•	사이클이 홀수면 한 그룹에서 한 개를 제외하고, 나머지 독립점의 최대 개수를 선택.
 *
 *
 * ✅ 홀수 길이 사이클이 있는 경우 해결 방법
 * 	•	사이클이 있는 그래프에서도 가능한 최대 독립점을 찾는 방법:
 * 	1.	빨간색 그룹과 검은색 그룹으로 나누고
 * 	2.	max(빨간색 그룹 개수, 검은색 그룹 개수) - 1을 반환
 * (홀수 사이클에서는 한 개를 제거해야 독립점 조건을 만족할 수 있음)
 *
 * ✅  근데 홀수 길이 사이클 최대 3 밖에 안된다 왜냐면 그 이상이면 한 정점당 간선 2개 넘어감
 *
 * * **/

/**
 * [놓친 부분]
 * 홀수 길이 사이클은 3까지만 가능했다는것을 지금에서야 알았다. => 이런 이유로 잘못된 논리식을 구현 red--, black-- 이렇게 한거..
 * 양방향 그래프로 그렸어야했다.
 * */


/* input
6 4
1 2
2 3
3 4
4 5

=> 4
----
7 6
1 2
2 3
1 3
4 5
5 6
6 7

=> 3
* */

public class Prob1_개선 {

	static int N;
	static int M;
	static ArrayList<Integer>[] array;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//1. 초기화
		visited = new int[N+1];
		array = new ArrayList[N+1];
		for(int i = 1; i <=N; i++){
			array[i] = new ArrayList<>();
		}

		//2. 입력 받음 M개의 간선들
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			array[u].add(w);
			array[w].add(u);  // 🚨 양방향 추가 필수!
		}

		//3. N번 반복문을 돌며서 만약 color == 0이면 BFS 진행
		int answer = 0;
		for(int i = 1; i <= N; i++){
			if(visited[i] == 0){
				answer += BFS(i);
			}
		}

		//4. 출력
		System.out.print(answer);

	}

	private static int BFS(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 1; // RED
		int red = 1;
		int black = 0;
		boolean hasOddCycle = false; // 🚨 사이클이 있는지 판단!!!!

		while (!queue.isEmpty()){
			int now = queue.poll();
			for (int next : array[now]) { //생각해보니까 JAVA8이라서 이거 동작 안했었음 그래서 일반 for문으로 바꿔서 풀었음
				if(visited[next] == 0) {
					visited[next] = -visited[now]; //반대 컬러
					queue.add(next);

					if(visited[next] == 1) red++;
					else black++;
				}else if (visited[next] == visited[now]) {
					// 🚨 홀수 길이 사이클 발생!
					hasOddCycle = true;
				}
			}
		}

		// 🚨 홀수 길이 사이클이 있으면 한 개를 제거해야 함.
		if (hasOddCycle) {
			return Math.max(red, black) - 1;
		} else {
			return Math.max(red, black);
		}
	}
}
