package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main2606 {
    static int node[][]; //그래프 배열
    static int check[]; //방문 배열
    
    static void bfs(int start) { // BFS 메소드
		Queue<Integer> queue = new LinkedList<>();
		
		check[start] =1;
		queue.offer(start);
		int cnt = 0; // 감염 된 컴퓨터의 수
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i=1;i<node.length;i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가 
				if(node[x][i]==1 && check[i]!=1) {
					queue.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt); //모든 탐색을 마치고 cnt 출력
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());  // 컴터수
        int m = Integer.parseInt(br.readLine()); // 엣지 수
        
        node=new int[n+1][n+1];
		check = new int[n+1];
		for(int i=0;i<m;i++) { // 그래프 구성
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
            int a = Integer.parseInt(st.nextToken()); //연결
            int b = Integer.parseInt(st.nextToken()); //연결

			node[a][b]=1;
			node[b][a]=1;
			
		}
		
		bfs(1);
    }
}
