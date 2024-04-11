package 백준.Silver;

import java.util.Scanner;

public class Main2003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;
        int end = 0;

        for(int j = 0; j < N; j++){
            while(sum < M && end < N){
                sum += A[end];
                end++;
            }
            if (sum == M){ count++; }
            sum -= A[j];
        }
        System.out.println(count);

    }
}
