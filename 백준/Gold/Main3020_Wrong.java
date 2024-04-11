package 백준.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3020_Wrong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] cave = new int[H][N];
        int[] ostacle = new int[N];

        //1. 장애물 순서대로 입력 받기
        for (int i = 0; i < N; i++) {
            ostacle[i] = Integer.parseInt(br.readLine());
        }

        //2-1. 0으로 일단 초기화
        for(int j = 0; j<H; j++){
            for (int i = 0; i<N; i++){
                cave[j][i] = 0;
            }
        }

        //2-2. 2차원 배열로 장애물이면 1 할당 하는 반복문 
        int check = 0; //석순은 0, 종유석은 1
        for(int j = 0; j < N; j++){ // [i][0], [i][1] ...[i][N] 까지
            int count = ostacle[j];

            if(check == 0) { // 석순 -> 아래서 //N은 6, H는 7
                for (int i = H-1;i > (H-1-count); i--){
                    cave[i][j] = 1;
                }
                check = 1;

            } else { //종유석 위에서 
                for (int i = 0; i < count; i++) {
                    cave[i][j] = 1;
                }
                check = 0;
            }
        }


        //3. 각 y 줄 마다 장애물(1)의 개수를 count 해서 배열에 저장 + 가장 작은거 알아내기
        int[] array = new int[H];
        for (int i = 0; i < H; i++) { //y
            int min_os = 0;

            for (int j = 0; j < N; j++) { //x
                if (cave[i][j] == 1){
                    min_os++;
                } 
            }

            array[i] = min_os;
        }


        //4. 정렬하기, 최소 값 구하기 
        Arrays.sort(array);
        int min_os = array[0];

        //5. 순차 탐색해서 몇개 겹치는 지 검색
        int min_os_count = 0;
        for (int i = 0; i < array.length; i++) {
            if (min_os == array[i]) {
                min_os_count++;
            }
            else if (min_os < array[i]) {
                break;
            }
        }

        System.out.println(min_os + " " + min_os_count);

    }
    
}
