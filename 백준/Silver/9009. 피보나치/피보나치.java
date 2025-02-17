
import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] d = new int[100];
    static int endIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i < d.length; i++){
            d[i] = d[i - 2] + d[i - 1];
            if(d[i] > 1000000000){
                endIdx = i;
                break;
            }
        }

        for(int i = 0; i < T; i++){
            int num = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            for(int j = endIdx; j >= 0; j--){
                if(num == 0) break;
                if(num >= d[j]){
                    list.add(d[j]);
                    num -= d[j];
                }
            }
            Collections.sort(list);
            for (Integer v : list) {
                bw.write(v + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}