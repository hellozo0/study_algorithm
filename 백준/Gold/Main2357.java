package 백준.Gold;

import java.io.*;
import java.util.StringTokenizer;

public class Main2357 {

    static int[] arr;
    static int[] mintree;
    static int[] maxtree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        mintree = new int[n * 4];
        maxtree = new int[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, n, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = getMax(1, n, 1, a, b);
            int min = getMin(1, n, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void init(int start, int end, int node) {
        if (start == end) {
            mintree[node] = maxtree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        maxtree[node] = Math.max(maxtree[node * 2], maxtree[node * 2 + 1]);
        mintree[node] = Math.min(mintree[node * 2], mintree[node * 2 + 1]);
    }

    private static int getMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        } else if (left <= start && end <= right) {
            return mintree[node];
        } else {
            int mid = (start + end) / 2;
            int l = getMin(start, mid, node * 2, left, right);
            int r = getMin(mid + 1, end, node * 2 + 1, left, right);
            return Math.min(l, r);
        }
    }

    private static int getMax(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        } else if (left <= start && end <= right) {
            return maxtree[node];
        } else {
            int mid = (start + end) / 2;
            int l = getMax(start, mid, node * 2, left, right);
            int r = getMax(mid + 1, end, node * 2 + 1, left, right);
            return Math.max(l, r);
        }
    }
}
