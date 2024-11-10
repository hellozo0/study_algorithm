import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> back;
    static Stack<Integer> front;
    static int now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //페이지 번호 N번까지만 존재
        int Q = Integer.parseInt(st.nextToken()); //명령 개수

        back = new LinkedList<>();
        front = new Stack<>();
        now = -1;

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            switch (command){
                case 'B' :
                    backFunction();
                    break;
                case 'F' :
                    frontFunction();
                    break;
                case 'C' :
                    compressFunction();
                    break;
                case 'A' :
                    int page = Integer.parseInt(st.nextToken());
                    accessFunction(page);
                    break;
            }
        }

        //출력 하는데 now -> back -> front 순으로 (없음 -1출력)
        System.out.println(now);

        if(back.isEmpty()) {
            System.out.println(-1);
        } else {
            while (!back.isEmpty()){
                System.out.print(back.pollLast() + " ");
            }
            System.out.println();
        }

        if(front.isEmpty()) {
            System.out.println(-1);
        } else {
            while (!front.isEmpty()){
                System.out.print(front.pop() + " ");
            }
        }
    }

    private static void backFunction(){
        //조건 1 : back dq에 값이 1개 이상 있을 때만 수행한다
        if(back.isEmpty()) return;

        //현재 보고 있는 페이지를 front에 넣고 back에서 최신것을 가져와서 now로 설정
        front.add(now);
        now = back.pollLast();
    }

    private static void frontFunction(){
        //조건 1 : front stack에 값이 1개 이상 있을 때만 수행한다
        if(front.isEmpty()) return;

        //현재 보고 있는것은 back에 넣기
        back.offerLast(now);
        now = front.pop();
    }

    private static void accessFunction(int page){
        //1. 초기화
        front = new Stack<>();

        //now가 아직 없을 수도 있음  그렇다면 back에 넣지 않는다.
        if(now != -1) {
            back.offerLast(now);
        }
        now = page;
    }

    private static void compressFunction(){
        if(back.isEmpty()) return;


        int backWardSize = back.size();
        int first = 0;
        if(backWardSize != 0 ) {
            first = back.pollFirst();
        }

        for(int i = 1; i < backWardSize; i++){

            if(first !=  back.peekFirst()) {
                back.offerLast(first);
                first = back.pollFirst();
            } else {
                back.pollFirst();
            }
        }
        back.offerLast(first);
    }
}