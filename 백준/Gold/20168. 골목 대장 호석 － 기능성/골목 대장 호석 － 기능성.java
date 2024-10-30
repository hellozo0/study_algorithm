
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int start;
	private static int target;
    private static int answer;
	private static boolean[] visited;
	private static int[] distance;
	private static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		//1. 자료구조 선언
		visited = new boolean[N + 1];
		distance = new int[N + 1];
		list = new ArrayList[N + 1];
		Stack<Edge> stack = new Stack<>();
		answer = Integer.MAX_VALUE;
        int minPay = Integer.MIN_VALUE;

		//2. 초기화
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(w, v));
		}
		
		distance[start] = 0;
        visited[start] = true;
        dfs(new Edge(start,0), money, minPay);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void dfs(Edge now, int money, int minPay) {
		//지금 BFS처럼 2,4,3,5 이런식은데 그게아니라 DFS 형태로 탐색할 수 있게 해야함
		// while (!pq.isEmpty()){ // 4번 먼저 들어오고, 2번 들어옴
		// Edge now = pq.poll();
		int nowVertex = now.vertex;

		//target에 도착하는 경우 2번 생기
		if (nowVertex == target) {
			//처음 도착하는 경우
			if (answer == Integer.MAX_VALUE || answer > minPay) {
				answer = minPay;
			}
		}

		for (Edge next : list[nowVertex]) { //2랑 4를 넣을텐데

			int nextVertex = next.vertex;
			int nextValue = next.value;

			if (!visited[nextVertex] && money >= nextValue ) {
                visited[nextVertex] = true;
                dfs(next, money-nextValue,Math.max(minPay,nextValue));
                visited[nextVertex] = false;

			}
        }
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
		return value - e.value;
	}

}