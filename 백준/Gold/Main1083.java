package 백준.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1083 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] sort_Num = new int[N];

        for(int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sort_Num[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        int temp = 0;


        //만약 제일 큰수가 제일 앞에 있다면 맨 앞으로 끌고 와야함

        for(int i = 0; i < S; i++){
            if (sort_Num[i] < sort_Num[i+1] && i+1 <= N) {
                temp = sort_Num[i+1];
                sort_Num[i+1] = sort_Num[i];
                sort_Num[i] = temp;
            }
        }


        for (int i = 0; i < N; i++){
            System.out.println(sort_Num[i] + " ");
        }
    }
    
}
