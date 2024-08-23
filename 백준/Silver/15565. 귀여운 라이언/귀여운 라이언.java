
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) arr.add(i);
        }

        if(arr.size() < k) {
            answer = -1;
        }

        for(int i = 0; i < arr.size()-k+1; i++){

            answer = Math.min(answer, arr.get(i+k-1) - arr.get(i)+1);
        }

        System.out.println(answer);
    }
}
