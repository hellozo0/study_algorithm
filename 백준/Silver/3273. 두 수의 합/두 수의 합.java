
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken()); //5, 12, 7, 10, 9, 1, 2, 3, 11
        }
        int target = Integer.parseInt(br.readLine()); //13

        Arrays.sort(numbers); //1,2,3,5,7,9,10,11,12
        int start = 0;
        int end = n-1;
        int count = 0;

        while (start < end){
            if( numbers[start] + numbers[end] == target){
                count++;
                start++;
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);

    }
}
