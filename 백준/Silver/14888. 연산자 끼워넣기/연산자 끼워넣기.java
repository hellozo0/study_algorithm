import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int[] num;
    static int[] operator;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        num = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        //본격 로직 구현 완탐인데 - 재귀?
        //결과값은 총 operator 수의 합의 팩토리얼 만큼 존재한다.
        dfs(num[0],1);
        System.out.print(maxNum + " ");
        System.out.print(minNum + " ");

    }
    private static void dfs(int before, int idx){
        if(idx == n){
            maxNum = Math.max(maxNum, before);
            minNum = Math.min(minNum, before);
            return;
        }

        for(int i = 0; i < 4; i++){

            if(operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(before+num[idx],idx+1);
                        break;
                    case 1:
                        dfs(before-num[idx],idx+1);
                        break;
                    case 2:
                        dfs(before*num[idx],idx+1);
                        break;
                    case 3:
                        dfs(before/num[idx],idx+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}