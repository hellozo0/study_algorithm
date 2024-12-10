import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 0;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            tc++;
            int answer = 0;

            HashMap<String, String> map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                map.put(from,to);
                list.add(from);
            }
            for(String start : list) {
                String end = map.get(start);
                while(true){
                    end = map.get(end); //다음 체인으로 이동
                    if(end == null) { //체인이 아닌경우
                        break;
                    } else if (end.equals(start)) { //체인인 경우
                        answer++;
                        map.remove(start);
                        break;
                    }
                }
            }
            System.out.println(tc + " " + answer);
        }
    }
}