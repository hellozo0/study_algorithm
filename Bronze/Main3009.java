package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3009 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine()," ");       
        int[] arr1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		
        st = new StringTokenizer(br.readLine()," ");
		int[] arr2 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		
        st = new StringTokenizer(br.readLine()," ");
		int[] arr3 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        
        int x = 0,y = 0;

        if(arr1[0] == arr2[0]){
            x = arr3[0];
        }
        else if (arr1[0] == arr3[0]){
            x = arr2[0];
        }
        else if (arr2[0] == arr3[0]){
            x = arr1[0];
        }

        if(arr1[1] == arr2[1]){
            y = arr3[1];
        }
        else if (arr1[1] == arr3[1]){
            y = arr2[1];
        }
        else if (arr2[1] == arr3[1]){
            y = arr1[1];
        }

        System.out.println(x + " " + y);
        
    }
}