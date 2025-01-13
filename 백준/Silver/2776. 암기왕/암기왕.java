import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //수첩 2에 있는 숫자가 수첩 1에 있으면 1, 없으면 0
        //해시 맵 쓰면 될거 같은데 or Set
        //검색 용도니까

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < tc; i++){
            int note1 = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < note1; j++){
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }

            int note2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < note2; j++){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            }
        }

        System.out.println(sb.toString());

    }
}