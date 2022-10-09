package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// public class Main2751 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		StringBuilder sb = new StringBuilder();
		
// 		int N = Integer.parseInt(br.readLine());
		
// 		// list 계열 중 하나를 쓰면 된다.
// 		ArrayList<Integer> list = new ArrayList<>();
		
// 		for(int i = 0; i < N; i++) {
// 			list.add(Integer.parseInt(br.readLine()));
// 		}
		
// 		Collections.sort(list);
		
// 		for(int value : list) {
// 			sb.append(value).append('\n');
// 		}
// 		System.out.println(sb);
//     }
// }

public class Main2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        //Bottom - up 방식으로 부분 리스트 나눅기 
        merge_sort(array);

        for(int value : array) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
    }

    private static int[] sorted;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void merge_sort(int[] a) {
		
		sorted = new int[a.length];
		merge_sort(a, 0, a.length - 1);
		sorted = null;
	}

    // Bottom-Up 방식 구현
	private static void merge_sort(int[] a, int left, int right) {
		
		/*
		 * 1 - 2 - 4 - 8 - ... 식으로 1부터 서브리스트를 나누는 기준을 두 배씩 늘린다.
		 */
		for(int size = 1; size <= right; size += size) {
			
			/*
			 * 두 부분리스트을 순서대로 병합해준다.
			 * 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
			 * 왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
			 * 왼쪽 부분리스트는 low = mid = 0 이고,
			 * 오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.
			 *  
			 * 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이
			 * 병합되도록 해야한다. 
			 */
			for(int l = 0; l <= right - size; l += (2 * size)) {
				int low = l;
				int mid = l + size - 1;
				int high = Math.min(l + (2 * size) - 1, right);
				merge(a, low, mid, high);		// 병합작업
			}
		}
	}

    private static void merge(int[] a, int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
		
		while(l <= mid && r <= right) {
			/*
			 *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
			 *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
			 */
			if(a[l] <= a[r]) {
				sorted[idx++] = a[l++];
			}
			/*
			 *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
			 *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
			 */
			else {
				sorted[idx++] = a[r++];
			}
		}
		
		/*
		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
		 * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		if(l > mid) {
			while(r <= right) {
				sorted[idx++] = a[r++];
			}
		}
		
		/*
		 * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
		 * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
		 * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
		 */
		else {
			while(l <= mid) {
				sorted[idx++] = a[l++];
			}
		}
		
		/*
		 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		 */
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
}

