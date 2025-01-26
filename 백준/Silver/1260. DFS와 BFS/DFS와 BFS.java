
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	// static ArrayList<Integer>[] array;
	static boolean[][] array2;
    static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		//1. 자료구조 초기화
		visited = new boolean[N + 1];
		array2 = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
            array2[u][w] = true;
            array2[w][u] = true;

		}

		// array = new ArrayList[N+1];
		// for(int i = 1; i < N+1; i++){
		//     array[i] = new ArrayList<>();
		// }
		// for(int i = 0; i < M; i++){
		//     st = new StringTokenizer(br.readLine());
		//     int u = Integer.parseInt(st.nextToken());
		//     int w = Integer.parseInt(st.nextToken());
		//     array[u].add(w);
		// }

		//2. DFS
		dfs(start);
		sb.append("\n");
		// dfs_stack(start);

		//3. BFS
		Arrays.fill(visited, false);
		bfs(start);
		System.out.println(sb);

	}

	public static void dfs(int start) {

		visited[start] = true;
		sb.append(start).append(" ");

        for(int i = 1; i <= N; i++){
            if(array2[start][i]&& !visited[i]){
                dfs(i);
            }
        }

		// for (int node : array[start]) {
		// 	if (!visited[node]) {
		// 		dfs(node);
		// 	}
		// }
	}

	// public static void dfs_stack(int start) {
    //
	// 	Stack<Integer> stack = new Stack<>();
	// 	stack.push(start);
	// 	visited[start] = true;
    //
	// 	while (!stack.isEmpty()) {
	// 		int now = stack.pop();
	// 		sb.append(now + " ");
    //
	// 		for (int node : array[now]) {
	// 			if (!visited[node]) {
	// 				stack.push(node);
	// 				visited[node] = true;
	// 			}
	// 		}
	// 	}
	// }

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");

            for(int i = 1; i <=N; i++){
                if(array2[now][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
			// for (int node : array[now]) {
			// 	if (!visited[node]) {
			// 		queue.add(node);
			// 		visited[node] = true;
			// 	}
			// }
		}
	}
}