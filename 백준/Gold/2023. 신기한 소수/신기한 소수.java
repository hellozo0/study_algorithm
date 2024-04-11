

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int start, int n){

        //1. 자릿수 만족 && 소수면 출력
        if(n == N) {
            if (isPrime(start)) System.out.println(start);
            return;
        }

        //2. 과정 (1,3,5,7,9)
        for(int i = 1; i < 10; i+=2){
            if(isPrime(start * 10 + i)){
                DFS(start * 10 + i, n+1);
            }
        }
    }

    static boolean isPrime(int num){
        for(int i = 2; i < num/2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
