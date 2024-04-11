package 백준.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// public class Main10989 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
		
//         int N = Integer.parseInt(br.readLine());
//         int[] array = new int[N];

//         for (int i = 0; i < N; i++) {
//             array[i] = Integer.parseInt(br.readLine());
//         }

//         quickSort(array,0,array.length-1);

//         for(int value : array){
//             sb.append(value).append("\n");
//         }
//         System.out.println(sb);
//     }

//     private static void quickSort(int[] array, int start, int end){
//         if (start >= end) return;

//         int pivot = start;
//         int left = start + 1;
//         int right = end;
//         int temp;

//         while(left <= right){
//             //피봇보다 큰 경우 left 값 필요
//             while(array[pivot] >= array[left]){
//                 left++;
//             }
//             //피봇보다 작은 경우 right 값 필요
//             while(array[pivot] <= array[right] && right > start){
//                 right--;
//             }

//             if(left > right) {
//                 temp = array[right];
//                 array[right] = array[start];
//                 array[start] = temp;
//             } else {
//                 temp = array[right];
//                 array[right] = array[left];
//                 array[left] = temp;
//             }
//         }

//         quickSort(array, start, right-1);
//         quickSort(array, right+1, end);

//     }
    
// }



public class Main10989 {
    public static void main(String[] args) throws IOException{
         // 수의 범위 (0 ~ 10000) 사실상 0은 제외
         int[] cnt = new int[10001];
 
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
         int N = Integer.parseInt(br.readLine());
  
         for (int i = 0; i < N; i++) {
             // 해당 인덱스의 값을 1 증가
             cnt[Integer.parseInt(br.readLine())] ++;
         }
  
         br.close();
  
         StringBuilder sb = new StringBuilder();
  
         // 0은 입력범위에서 없으므로 1부터 시작
         for(int i = 1; i < 10001; i++){
             // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
             while(cnt[i] > 0){
                 sb.append(i).append('\n');
                 cnt[i]--;
             }
         }
         System.out.println(sb);
    }
}