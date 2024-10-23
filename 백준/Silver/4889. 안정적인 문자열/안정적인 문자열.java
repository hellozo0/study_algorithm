
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true){
            String letters = br.readLine();
            if(letters.charAt(0) == '-') {
                break;
            }
            System.out.println(count + ". " + solution(letters));
            count++;
        }
    }
    private static int solution(String s){
        Stack<Character> stack = new Stack<>();
        int change = 0;

        for(int i = 0; i < s.length(); i++) { //}}{{일 경우
            char letter = s.charAt(i);
            if(letter == '{'){
                stack.add(letter); //{ 들어가고, { 들어감 => 1번 바꿔야함
            } else { // }일경우
                if(stack.isEmpty()){ //초반에
                    change++; //1 {
                    stack.add('{');
                } else { //안 비어있고 {만 들어있을테니까
                    stack.pop();
                }
            }
        }
        return change + stack.size()/2;
    }
}
