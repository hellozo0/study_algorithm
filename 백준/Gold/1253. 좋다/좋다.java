
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        //투포인터
        for(int i = 0; i < N; i++) {
            int target = nums[i];
            int start = 0;
            int end = N-1;

            while(start < end) {
                if(nums[start] + nums[end] > target) {
                    end--;
                } else if (nums[start] + nums[end] < target){
                    start++;
                } else { // 같을 때
                    if(start != i && end != i) {
                        answer++;
                        break;
                    }
                    else if (start == i) {
                        start++;
                    }
                    else if (end == i) {
                        end--;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}