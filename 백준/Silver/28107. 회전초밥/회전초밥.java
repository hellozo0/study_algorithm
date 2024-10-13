
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        /* Ver1. 시간 초과.. 역시나... */
//        int[] reciept = new int[N];
//        ArrayList<Integer>[] customer = new ArrayList[N];
//        for(int i = 0; i < N; i++){
//            customer[i] = new ArrayList<>();
//            st = new StringTokenizer(br.readLine());
//            reciept[i] = Integer.parseInt(st.nextToken());
//            for(int j = 0; j <reciept[i]; j++){
//                customer[i].add(Integer.parseInt(st.nextToken()));
//            }
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < M; i++){
//            queue.add(Integer.parseInt(st.nextToken()));
//        }
//        int[] answer = new int[N];
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j <reciept[i]; j++){
//                for(int k = 0; k < queue.size(); k++){
//                    int sushi = queue.poll();
//                    if(sushi == customer[i].get(j)) answer[i]++;
//                    else queue.add(sushi);
//                }
//            }
//        }
//
//        for(int i = 0; i < N; i++){
//            System.out.print(answer[i] + " ");
//        }

        /* Ver2.  - 백준 유형 에 우선순위큐가 있어서 사용해 봤다 && 구글링 */
        /*
        처음 접근법
        PriorityQueue<Integer>[] pq = new PriorityQueue[초밥번호MAX값];
        하려고 했는데 스시 번호가 뭐가 MAX 인지 몰라서 할 수 가 없다. 그렇다고 200.000개를 미리 다 선언해서 공간 할당 할수는 없으니..
        PQ 안에 {},{},{} 형태로 {초밥번호, 먹을사람번호} 이렇게 해서 초밥번호 순으로 오름차순 && 먹을 사람 번호로도 오름차순 해야하는 방법 밖에 없었다. 
        --> 이부분을 구글링함 
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // 스시 요청 한 고객 들 오름차순
                }
                return o1[0] - o2[0]; // 스시 이름 오름차순
            }
        });

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num ; j++){
                int sushi = Integer.parseInt(st.nextToken());
                pq.add(new int[]{sushi, i});
            }
        }

        PriorityQueue<Integer> sushiTable = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            sushiTable.add(Integer.parseInt(st.nextToken()));
        }

        int answer[] = new int[N];

        while(!sushiTable.isEmpty()){
            if(pq.isEmpty()) break;

            //초밥 번호가 동일하다면
            if(pq.peek()[0] == sushiTable.peek()){
                answer[pq.poll()[1]]++;
                sushiTable.poll();
            }
            else if(pq.peek()[0] < sushiTable.peek()) { //초밥 번호 < 스시 만든거 테이블
                pq.poll();
            }
            else { //초밥 번호가 더 크면 >
                sushiTable.poll();
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
