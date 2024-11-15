import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Main {

    static int[] digit = new int[]{9,8,7,6,5,4,3,2,1,0};
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        dfs(0, 0);
        Collections.sort(list);

        if (list.size() <= N-1) {
            System.out.println("-1");
        } else {
            System.out.println(list.get(N-1));
        }
    }

    private static void dfs(long num, int index){
        if(!list.contains(num)){
            list.add(num);
        }

        if(index>=10) {
            return;
        }

        dfs((num * 10) + digit[index], index+1);
        dfs(num, index+1);
    }
}

//DP로 풀면 안된다