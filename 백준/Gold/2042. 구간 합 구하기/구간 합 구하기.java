import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 데이터 변경 개수
        int k = Integer.parseInt(st.nextToken()); // 구간합 구하는 횟수

        // 수 저장 배열
        long[] arr = new long[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree stree = new SegmentTree(n);

        stree.init(arr,1,1,n);

        for(int i = 0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());

            // 명령어
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            // 원소의 범위는 2^63이므로 롱타입으로 받아야한다.
            long b = Long.parseLong(st.nextToken());

            // 데이터 변경 명령어
            if(cmd == 1){
                stree.update(1,1,n,a,b-arr[a]);
                arr[a] = b;
                // 구간합 명령어
            }else{
                bw.write(stree.sum(1,1,n,a,(int)b) +"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static class SegmentTree{
        long tree[];
        int treeSize;

        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start,int end){

            if(start == end){
                return tree[node] = arr[start];
            }

            return tree[node] =
                    init(arr,node*2,start,(start+ end)/2)
                            + init(arr,node*2+1,(start+end)/2+1,end);
        }

        public void update(int node, int start, int end, int idx, long diff){
            if(idx < start || end < idx) return;

            tree[node] += diff;

            if(start != end){
                update(node*2, start, (start+end)/2, idx, diff);
                update(node*2+1, (start+end)/2+1, end, idx, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }

            if(left <= start && end <= right){
                return tree[node];
            }

            return sum(node*2, start, (start+end)/2, left, right)+
                    sum(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}