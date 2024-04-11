package 백준.Silver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2606 {

	static boolean[] visited;
	static int[][] arr;

	static int count;

    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //노드의 수 ( 컴퓨터의 수 )
		int M = sc.nextInt(); //간선의 수 ( 연결되어 있는 컴퓨터 쌍의 수  )

		arr = new int[N+1][N+1];

		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		count = 0;

		visited = new boolean[N+1];
		bfs(1);

		System.out.println(count);
	}

	public static void bfs(int V){
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		visited[V] = true;

		while (!q.isEmpty()){
			int next = q.poll();
			for(int i = 1; i < arr.length; i++){
				if(arr[next][i] == 1 && visited[i] == false){
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}
