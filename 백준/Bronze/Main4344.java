package 백준.Bronze;
import java.util.*;


public class Main4344 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();

        for (int i =0; i < C; i++){
            Double sum = (double) 0, ave = (double) 0, count = (double) 0;
            int stu_num = sc.nextInt();
            int[] arr = new int[stu_num];

            for(int j = 0; j < stu_num; j++){
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            ave = sum / stu_num;

            for(int k = 0; k < stu_num; k++){
                if (arr[k] > ave){
                    count++;
                }
            }
            System.out.printf("%.3f%%\n",(count / stu_num)*100);

        }
        sc.close();
    }   
}
