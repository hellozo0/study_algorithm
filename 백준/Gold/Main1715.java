package 백준.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
    public static void main(String[] args) throws IOException {
        //A+B번 비교
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		
		for (int i=0; i<n; i++) {
			queue.add(Long.parseLong(br.readLine()));
		}
		
		long num = 0;
		while (queue.size() > 1) {
			long temp1 = queue.poll();
			long temp2 = queue.poll();
			
			num += temp1 + temp2;
			queue.add(temp1 + temp2); 
		}
		
		System.out.println(num);

    }
}
