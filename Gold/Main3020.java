package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3020 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        //1. 석순과 종유석 up과 down으로 입력 받기 
        int[] down = new int[N/2];
        int[] up = new int[N/2];
        for(int i = 0; i < N/2; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            down[i] = a;
            up[i] = b;
        }


        //2. up,down 각각 정렬하기
        Arrays.sort(up);
        Arrays.sort(down);

        //3. 비교
        int min = N;
        int count = 0;
        for (int i = 1; i < H+1; i++) {
            int result = binarySearch(0,N/2, i,down) + binarySearch(0, N/2, H-i+1, up);
        
            if (min == result) {
                count++;
                continue;
            }
            if (min > result) {
                min = result;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
    
    static int binarySearch(int left, int right, int key, int[] arr){
        while(left < right){
            int mid = (left + right) / 2;

            if (arr[mid] >= key) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return arr.length-right;
    }

    
}


/*
 * 
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] down = new int[h+2];
		int[] up = new int[h+2];
		for(int i=1; i<=(n)/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = h-Integer.parseInt(br.readLine())+1;
			down[a]++;
			up[b]++;
		}
		for(int i=1; i<=h; i++) {
			down[i] += down[i-1];
		}
		
		for(int i=h; i>=1; i--) {
			up[i] += up[i+1];
		}
		
		int min = n;
		int cnt=0;
		for(int i=1; i<h+1; i++	) {
			int dif = (down[h]-down[i-1]) + (up[1]-up[i+1]);
			
			if(dif<min) {
				min = dif;
				cnt=1;
			}else if(dif == min) cnt++;
		}
		System.out.println(min +" " + cnt);
	}
}
 */