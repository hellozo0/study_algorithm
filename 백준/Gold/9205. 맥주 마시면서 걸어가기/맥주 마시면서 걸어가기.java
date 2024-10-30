
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            //1. 자료구조 선언
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N+2]; //0,1,2,3 (N+2 = 4)
            list = new ArrayList<>();

            for(int j = 0; j < N+2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Edge(x,y));
            }
            System.out.println(bfs()?"happy":"sad");
        }
    }

    private static boolean bfs(){
        visited[0] = true; //0번쨰 꺼 방문하고
        Queue<Edge> queue = new LinkedList<>();
        queue.add(list.get(0));
        Edge target = list.get(N+1);

        while (!queue.isEmpty()){
            Edge now = queue.poll();

            if(Math.abs(target.y- now.y) + (Math.abs(target.x - now.x)) <= 1000){
                return true;
            }

            for(int i = 1; i < N+1; i++){ //1,2번쨰만(편의점만!
                if(!visited[i]){
                    Edge next = list.get(i);


                    if(Math.abs(next.y - now.y) + Math.abs(next.x - now.x) <= 1000){
                        visited[i] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return false;
    }
}

class Edge {
    int x;
    int y;

    Edge(int x, int y){
        this.x = x;
        this.y = y;
    }
}