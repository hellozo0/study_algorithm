package Silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main11279 {
    public static class maxHeap {

        private List<Integer> heap;

        public maxHeap() {
            heap = new ArrayList<>();
        }

        public void push(int val) {
            heap.add(val);
            int idx = heap.size() - 1;

            while (idx > 0 && heap.get((idx - 1) / 2) < heap.get(idx)) {
                swap((idx - 1) / 2, idx, heap.get((idx - 1) / 2), heap.get(idx));
                idx = (idx - 1) / 2;
            }
        }

        private void swap(int to, int from, int a, int b) {
            int tmp = a;
            heap.set(to, b);
            heap.set(from, tmp);
        }

        public int pop() {
            if (heap.isEmpty())
                return 0;

            int delete = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int here = 0;
            while (true) {
                int left = here * 2 + 1, right = here * 2 + 2;

                int next = here;
                if (left < heap.size() && heap.get(next) < heap.get(left)) {
                    next = left;
                }
                if (right < heap.size() && heap.get(next) < heap.get(right)) {
                    next = right;
                }

                if (next == here)
                    break;
                swap(here, next, heap.get(here), heap.get(next));
                here = next;
            }
            return delete;
        }

    }

    public static void main(String[] args) {
        maxHeap heap = new maxHeap();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                System.out.println(heap.pop());
            } else {
                heap.push(x);
            }
        }
    }

}
