package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

public class Main1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        //여기까지 입력 완료

        //정렬하기 - 커스텀 (0번 index,1번 index 기준으로)
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2){

                if( o1[1] == o2[1]) { //종료 시간이 같을 경우 시작시간이 빠른 순서로 정렬
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        //카운트 하기 (조건에 맞게)
        int count = 0;
        int prev = 0;
        for(int i = 0; i < N; i++) {
            //직전 종료 시간이 다음 회의 시간 시작보다 작거나 같다면 갱신
            if(prev <= time[i][0]) {
                prev = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
    
}
