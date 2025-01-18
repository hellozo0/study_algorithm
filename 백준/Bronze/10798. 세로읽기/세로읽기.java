import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //총 5줄 입력받음 그리고 세로로 아 이거 그건데 대각선으로 flip
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] letters = new String[5][15];

        for(int i = 0; i < 5; i++){
            String s = br.readLine();
            Arrays.fill(letters[i], "?");
            for(int j = 0;j < s.length(); j++){
                letters[i][j] = String.valueOf(s.charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(letters[j][i] == "?") continue;

                sb.append(letters[j][i]);
            }
        }

        System.out.println(sb.toString());
    }
}