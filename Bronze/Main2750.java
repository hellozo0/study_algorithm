package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        //버블 sort
        for(int i = 0; i < array.length ; i++) {
            for (int j = 1; j < array.length -i; j++) {
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];  
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(array[i]);
        }

    }
    
}
