
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] alphabet = new int[26][26];

        //초기화 1000으로
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++) {
                if(i != j) alphabet[i][j] = 1000;
            }
        }

        //입력받은 값을 배열에 저장 1로
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = st.nextToken().charAt(0) - 'a'; //a를 숫자로 --> 0
            st.nextToken();
            int end = st.nextToken().charAt(0) - 'a'; //b를 숫자로
            alphabet[start][end] = 1;
        }

        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                if(i == k) continue;
                for(int j = 0; j < 26; j++){
                    if(i == j || k == j) continue;
                    alphabet[i][j] = Math.min(alphabet[i][j], alphabet[i][k]+alphabet[k][j]);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = st.nextToken().charAt(0) - 'a'; //a를 숫자로 --> 0
            st.nextToken();
            int end = st.nextToken().charAt(0) - 'a'; //d를 숫자로 --> 3

            if (alphabet[start][end] != 0 && alphabet[start][end] < 1000) {//이어져 있을 경우에는
                System.out.println('T');
            } else {
                System.out.println('F');
            }
        }

    }
}
