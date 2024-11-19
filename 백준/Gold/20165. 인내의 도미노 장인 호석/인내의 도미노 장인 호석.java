import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int R;
    static int[][] domino;
    static boolean[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        answer = 0;
        domino = new int[N+1][M+1];
        map = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                domino[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 2*R; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if( i % 2 == 0) { //공격
                char direction = st.nextToken().charAt(0);
                attack(x,y,direction);
            } else { //수비
                defense(x,y);
            }
        }

        System.out.println(answer);
        for (int i = 1; i <= N; i++){
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j <=M; j++){
                if(!map[i][j]) {
                    sb.append("S ");
                } else {
                    sb.append("F ");
                }
            }
            System.out.println(sb.toString());
        }

    }

    private static void attack(int x, int y, char direction){
        int count = 1;
        //false = 기본 ( 세워져 있는것)
        switch (direction) {
            case 'E' :
                for (int i = y; i <= M; i++){ //열이 오른쪽으로 증가
                    if(!map[x][i] && count > 0){ //if count
                        count = Math.max(count, domino[x][i]);
                        count--;
                        map[x][i] = true;
                        answer++;
                    } else if(map[x][i]){ //true면 이미 넘어진거임
                        count--;
                    }
                }
                break;
            case 'S' :
                for (int i = x; i <= N; i++){ //행이 아래로 증가
                    if(!map[i][y] && count > 0){ //if count
                        count = Math.max(count, domino[i][y]);
                        count--;
                        map[i][y] = true;
                        answer++;
                    } else if(map[i][y]){ //true면 이미 넘어진거임
                        count--;
                    }
                }
                break;
            case 'W' :
                for (int i = y; i >= 1; i--){ //열이 왼쪽으로 증가
                    if(!map[x][i] && count > 0){ //if count
                        count = Math.max(count, domino[x][i]);
                        count--;
                        map[x][i] = true;
                        answer++;
                    } else if(map[x][i]){ //true면 이미 넘어진거임
                        count--;
                    }
                }
                break;
            case 'N' :
                for (int i = x; i >= 1; i--){ //행이 위로 즐가
                    if(!map[i][y] && count > 0){ //if count
                        count = Math.max(count, domino[i][y]);
                        count--;
                        map[i][y] = true;
                        answer++;
                    } else if(map[i][y]){ //true면 이미 넘어진거임
                        count--;
                    }
                }
                break;
        }
    }

    private static void defense(int x, int y){
        map[x][y] = false;
    }

}
