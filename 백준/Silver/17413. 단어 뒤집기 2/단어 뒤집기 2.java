import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '<') { // < 만났을 경우
                flag = true;
                while (!stack.isEmpty()) { //이전까지의 값들 중에 stack 에 있을 경우
                    sb.append(stack.pop()); //pop해서 flip 해서 넣기
                }
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == '>'){// > 만났을 경우
                flag = false; //flag 값 변경
                sb.append(s.charAt(i)); // >를 sb에 넣기
            }
            else if (flag){ //< 이후의 글자
                sb.append(s.charAt(i));
            }
            else if (!flag){
                if(s.charAt(i) == ' '){ //공백 만나면 단어 구분해서 flip
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i)); //공백 넣기
                } else { //공백 아닐 경우 일단 stack에 넣기
                    stack.push(s.charAt(i));
                }
            }

            if( i == s.length()-1){ //마지막 일때
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb.toString());

    }
}
