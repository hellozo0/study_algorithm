import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] relation;
	static boolean[] checked;
	static int res = -1;
    
	public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = sc.nextInt();
        
		//int n = Integer.parseInt(br.readLine());
        
		relation = new ArrayList[n+1];
		checked = new boolean[n+1];
        
		for(int i=1; i<n+1; i++) {
			relation[i] = new ArrayList<>();
		}
		
        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		//int x = Integer.parseInt(st.nextToken());
		//int y = Integer.parseInt(st.nextToken());
		
		//int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
            int p = sc.nextInt();
			int c = sc.nextInt();
            
			//st = new StringTokenizer(br.readLine());
			//int p = Integer.parseInt(st.nextToken());
			//int c = Integer.parseInt(st.nextToken());
			relation[p].add(c);
			relation[c].add(p);
		}
		
		dfs(x,y, 0);
		System.out.println(res);
	}
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			res = cnt; //둘이 만나면 
			return; 
		}
		
		checked[start] = true;
		for(int i=0; i<relation[start].size(); i++) { 
			int next = relation[start].get(i);
			if(!checked[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}
}