package Silver;
import java.util.*;

public class Main1316 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int count = tc;

        for (int i = 0;i < tc; i++){
            String str = sc.next();
            boolean[] check = new boolean[26]; //문자 개수
            
            for(int j = 1; j < str.length();j++){
                if (str.charAt(j-1) != str.charAt(j)){ //현재 문자와 이전문자가 같지 않다면
                    //이전에 나온 적이 있다면
                    if (check[str.charAt(j) - 'a'] == true){ 
                        count--;
                        break;
                    }
                    //처음 나온다면
                    else {
                        check[str.charAt(j-1) - 'a'] = true; //배열의 현재 단어 위치를 true로 변경
                    }
                }
            }
        }
        System.out.println(count);
    }
}
