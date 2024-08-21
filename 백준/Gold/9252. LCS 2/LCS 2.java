import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main{

    static long[][] dp;
    static char[] A;
    static char[] B;
//    static ArrayList<Character> Path;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        dp = new long[A.length+1][B.length+1];
//        Path = new ArrayList<>();

        for(int i = 1; i <= A.length; i++){
            for (int j = 1; j <= B.length; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[A.length][B.length]);

        getText(A.length, B.length);


        StringBuilder sb = new StringBuilder();
        //출력 반대로 돌리기
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());


    }

    private static void getText(int i, int j){

        stack = new Stack<>();

        while (i>0 && j>0){
            if(i==0 || j ==0) break;

            if(A[i-1] == B[j-1]){ //else
                stack.push(A[i-1]);
                i--;
                j--;
            } else{
                if(dp[i-1][j] > dp[i][j-1]){ //dp[i][j] == dp[i-1][j]
                    i--;
                } else { // dp[i][j] == dp[i][j-1]
                    j--;
                }
            }
        }

    }
}
