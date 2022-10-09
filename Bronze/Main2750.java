package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// public class Main2750 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int N = Integer.parseInt(br.readLine());
//         int[] array = new int[N];

//         for (int i = 0; i < N; i++) {
//             array[i] = Integer.parseInt(br.readLine());
//         }

//         //버블 sort
//         for(int i = 0; i < array.length ; i++) {
//             for (int j = 1; j < array.length -i; j++) {
//                 if (array[j-1] > array[j]) {
//                     int temp = array[j-1];  
//                     array[j-1] = array[j];
//                     array[j] = temp;
//                 }
//             }
//         }

//         for (int i = 0; i < N; i++) {
//             System.out.println(array[i]);
//         }

//     }
    
// }

public class Main2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        //slection sort
        for(int i = 0; i < array.length ; i++) {
            
            int min_index = i;
            //최소값 인덱스 찾기
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }

            int temp = array[min_index];  
            array[min_index] = array[i];
            array[i] = temp;

        }

        for (int i = 0; i < N; i++) {
            System.out.println(array[i]);
        }
    }
}