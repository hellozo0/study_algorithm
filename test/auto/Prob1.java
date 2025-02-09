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

public class Prob1 {

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
		int color = 1; //RED
		queue.add(start);
		visited[start] = color;
		int red = 1;
		int black = 0;

		while (!queue.isEmpty()){
			int now = queue.poll();
			for (int next : array[now]) { //생각해보니까 JAVA8이라서 이거 동작 안했었음 그래서 일반 for문으로 바꿔서 풀었음
				if(visited[now] != visited[next]) {
					visited[next] = -color;
					queue.add(next);

					if(visited[next] == 1) red++;
					else black++;
				} else {
					if(visited[next] == 1) red--;
					else black--;
				}
			}
			color = -color;
		}

		return Math.max(red,black);

	}
}
