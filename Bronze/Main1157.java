package Bronze;
import java.util.*;

public class Main1157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String letter = sc.next();
        int[] arr = new int[26];

        for (int i = 0; i < letter.length(); i++){
            if ( 'A' <= letter.charAt(i) && letter.charAt(i) <= 'Z' ){ //대문자  65 <= ... <= 90
                arr[letter.charAt(i) - 'A']++; //65
            }
            else { //소문자
                arr[letter.charAt(i) - 'a']++; //97
            } 
        }

        int max = -1;
        char ch = '?';

        for (int j = 0; j <26; j++){
            if (arr[j] > max){
                max = arr[j];
                ch = (char) (j+65); //대문자로 출력해줘야ㅑ함
            }
            else if (arr[j] == max){
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
