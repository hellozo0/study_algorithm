package 백준.Silver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//https://namhandong.tistory.com/185

public class Main2644 {

    static boolean[] visited;
    static int[][] arr;

    static int a;
    static int b;
    static int count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        count = 1;

        for(int i = 0; i < M;i++){
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            arr[p1][p2] = 1;
            arr[p2][p1] = 1;
        }

        bfs(a,b);

        if(visited[b] == false){
            System.out.println(-1);
        } else{
            System.out.println(count);
        }

    }

    public static void bfs(int  start, int end){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()){
            int next = q.poll();

            if(next == end) {
                break;
            }

            for(int i = 1; i < arr.length; i++){
                if(arr[next][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
//            if(q.contains(a) && q.contains(b)){
//                count++;
//                break;
//            } else if(q.contains(a) || q.contains(b)){
//                count++;
//            }

        }

//        if(visited[a] && visited[b]) {
//        } else if(visited[a] || visited[b]){ //서로 다른 가족이라는 거니까 -1
//            count = -1;
//        }


    }
}
