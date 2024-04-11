
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{


    static int S;
    static int P;
    static String DNA;
    static int count;
    static char[] ACGT = {'A', 'C', 'G', 'T'};
    static HashMap<Character, int[]> map = new HashMap<Character, int[]>();


    public static void main(String[] args) throws IOException {

        count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken()); // 총 문자열 길이
        P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        DNA = br.readLine(); // DNA STRING

        st = new StringTokenizer(br.readLine());

        //(1) map 에 A C G T 를 key 로 {현재 카운트, 입력 받은 조건 개수} 넣기
        //    map에는 A : {0,2} 이런식으로 저장되어 있을 것이다.
        for(char c : ACGT){
            map.put(c, new int[]{0, Integer.parseInt(st.nextToken())});
        }

        //(2) 세는 부분
        //    입력 받은 DNA 문자열에서 첫 문자 포함하여 P만큼 자른 후 ACGT에 해당하는 문자 세기 --> 조건 만족하는지 체크
        for(int i = 0; i < P; i++){
            map.get(DNA.charAt(i))[0]++; //현재 카운트 개수에 값을 더한다.
        }
        if(isFull()) count++;

        //(3) 슬라이딩 인덱스?
        //    인덱스를 1씩 증가시켜가며 슬라이딩 윈도우 적용(오른쪽으로 인덱스 하나씩 이동하여 부분문자열 만듦)
        for (int i = 0; i < S - P; i++) {
            map.get(DNA.charAt(i))[0] -= 1;
            map.get(DNA.charAt(i+P))[0] += 1;
            if (isFull()) count++;
        }

        System.out.println(count);

    }

    public static boolean isFull(){
        for(char c : ACGT){
            if (map.get(c)[0] < map.get(c)[1]) return false;
        }
        return true;
    }


}
