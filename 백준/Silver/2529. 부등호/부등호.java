
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import com.sun.jdi.connect.Connector;

public class Main {

    static int k;
    static boolean[] visited;
    static String[] gwalho;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        gwalho = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++){
            gwalho[i] = st.nextToken();
        }

        //문자열 인덱스
        tracking("",0);

        // Collections.sort(list);
        //최대값은 맨 뒤에 저장
        System.out.println(list.get(list.size()-1));
        System.out.print(list.get(0));

    }

    static void tracking(String num, int index){

        //마지막에 도달한다면
        if(index == k+1) {
            list.add(num);
            return;
        }

        //09
        for(int j = 0; j < 10; j++) {
            if(visited[j]) continue;

            //첫번째 시작이거나, 괄호 조건에 통과한다면
            if(index == 0 || (num.length() > 0 && check((num.charAt(index - 1) - '0'), j, gwalho[index - 1]))){
                visited[j] = true; //해당 숫자 바로 비교
                tracking(num+j, index+1);
                visited[j] = false;

            }

        }

    }

    static boolean check(int x, int y, String s) {
        if (s.equals("<")) {
            return x < y;
        } else {
            return x > y;
        }
    }
}