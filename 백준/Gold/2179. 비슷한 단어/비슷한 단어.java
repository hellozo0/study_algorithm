import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] letters = new String[N];
        for(int i = 0; i < N; i++){
            letters[i] = br.readLine();
        }

        int ans = -1;
        String ansLetter1 = "";
        String ansLetter2 = "";
        for(int i = 0; i < N; i++) {
            String first = letters[i];
            for(int j = i+1; j < N; j++){
                String second = letters[j];
                int cnt = countLetter(first,second);

                if(ans < cnt){
                    ans = cnt;
                    ansLetter1 = first;
                    ansLetter2 = second;
                }
            }
        }
        System.out.println(ansLetter1 + "\n" + ansLetter2);

    }

    private static int countLetter(String s1, String s2){
        int cnt = 0;

        int min = Math.min(s1.length(), s2.length());
        for(int i = 0; i < min; i++){
            if(s1.charAt(i) == s2.charAt(i)){
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}