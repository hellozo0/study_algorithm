package 백준.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String text = br.readLine();
        String bomb = br.readLine();

        int textLength = text.length();
        int bombLength = bomb.length();


        for(int i = 0; i < textLength; i++){
            //일단 sb에  문자를 넣음
            char c = text.charAt(i);
            sb.append(c);

            //sb에 있는 길이가 폭탄 길이와 같거나 길면 검사 시작 
            if (sb.length() >= bombLength) {
                boolean isSame = true;

                //폭탄문자열의 길이 만큼 반복문 수행 (sb에 문자가 하나씩 들어올때 마다 반복문 수행..!)
                for (int idx = 0; idx < bombLength; idx++){
                    //sb의 첫번째 문자랑 폭탄의 첫번째 문자랑 비교 --> 다르면 break. 
                    //만약 같다면 sb의 두번째 문자랑 폭탄의 두번째 문자랑 비교 
                    char c1 = sb.charAt(sb.length() - bombLength + idx);
                    char c2 = bomb.charAt(idx);

                    if (c1 != c2){
                        isSame = false;
                        break;
                    }
                }
                if (isSame){ //isSame이 true일 경우는 sb문자열의 끝 쪽에 bomb이 있는 거니까 뒷부분 빼기..!
                    //sb.delete(시작 index, 끝 index)
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }  
}
