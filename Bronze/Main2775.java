package Bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int T = Integer.parseInt(br.readLine());

        //아파트 만들기
        int[][] APT = new int[15][15];
        for(int i = 0; i <15; i++){
            APT[i][1] = 1; //i층 1호
            APT[0][i] = i; //0층 i호
        }
        //아파트 숫자 계산
        for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}


        for (int i = 0; i < T; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(APT[a][b]);
        }
    }
}
