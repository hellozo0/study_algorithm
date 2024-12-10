
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();

        int temp = 0;
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == ')') {
                temp = 0;
                while (!stack.isEmpty()) {
                    int next = stack.pop();
                    if (next == -1) { // '('를 -1로 저장
                        stack.push(temp == 0 ? 2 : 2 * temp);
                        temp = 0;
                        break;
                    } else if (next == -2) { // '[' 만나면 에러
                        System.out.println(0);
                        return;
                    } else { //숫자 들어 있으면
                        temp += next;
                    }
                }
                if (stack.isEmpty()) { //비어 있는데 닫는 괄호는 에
                    System.out.println(0);
                    return;
                }
            } else if (now == ']') {
                temp = 0;
                while (!stack.isEmpty()) {
                    int next = stack.pop();
                    if (next == -2) { // '['가 있으면
                        stack.push(temp == 0 ? 3 : 3 * temp);
                        temp = 0;
                        break;
                    } else if (next == -1) { // '(' 처리 오류
                        System.out.println(0);
                        return;
                    } else {
                        temp += next;
                    }
                }
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            } else if (now == '(') {
                stack.push(-1); // '('는 -1로 저장
            } else if (now == '[') {
                stack.push(-2); // '['는 -2로 저장
            } else {
                System.out.println(0);
                return;
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (now < 0) { // 남아있는 괄호가 있다면 에러
                System.out.println(0);
                return;
            }
            answer += now;
        }

        System.out.println(answer);
    }
}

// package org.example.p2504;
//
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Stack;
//
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String input = br.readLine();
//         Stack<Character> stack = new Stack<>();
//
//         //https://loosie.tistory.com/349
//
//         int temp = 0;
//         for(int i = 0; i < input.length(); i++){
//             char now = input.charAt(i);
//             boolean flag = true;
//
//             if(now == ')') {
//                 while(flag && !stack.isEmpty()) {
//                     char next = stack.pop();
//                     if(next == '(') {
//                         if(temp != 0) {
//                             stack.add((char)(2 * temp));
//                         } else {
//                             stack.add('2');
//                         }
//                         flag = false;
//                         temp = 0;
//                     }
//                     else if (next == '[' || next == ']' || next == ')'){
//                         System.out.println(0);
//                         return ;
//                     }
//                     else { //숫자 일 경우
//                         if(temp != 0) {
//                             temp = temp + Integer.parseInt(String.valueOf(next));
//                         } else {
//                             temp = Integer.parseInt(String.valueOf(next));
//                         }
//                     }
//                 }
//             } else if (now == ']') {
//                 while(flag && !stack.isEmpty()) {
//                     char next = stack.pop();
//                     if(next == '[') {
//                         if(temp != 0) {
//                             stack.add((char)(3 * temp));
//                         } else {
//                             stack.add('3');
//                         }
//                         flag = false;
//                         temp = 0;
//                     }
//                     else if (next == '(' || next == ')' || next == ']'){
//                         System.out.println(0);
//                         return ;
//                     }
//                     else { //숫자 일 경우
//                         if(temp != 0) {
//                             temp = temp + Integer.parseInt(String.valueOf(next));
//                         } else {
//                             temp = Integer.parseInt(String.valueOf(next));
//                         }
//                     }
//                 }
//             } else {
//                 stack.add(now);
//             }
//         }
//
//         //스택에 있는거 계산
//         int answer = 0;
//         while(!stack.isEmpty()){
//             char now = stack.pop();
//             if(now == '(' ||now == ')' || now == '['  || now == ']'){
//                 System.out.println(0);
//                 return;
//             }
//             answer += Integer.parseInt(String.valueOf(now));
//         }
//
//         System.out.println(answer);
//     }
// }