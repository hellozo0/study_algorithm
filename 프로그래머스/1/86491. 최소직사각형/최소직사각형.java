import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;        

        //(1) 배열 내부 먼저 정렬
        for(int i = 0; i < sizes.length; i++){
            Arrays.sort(sizes[i]); // 2채원 배열 정렬
        } // 50-60 , 30-70, 30-60, 40-80
        
        // System.out.println(sizes[0][0] + "  : " + sizes[0][1]);
        // System.out.println(sizes[1][0] + "  : " + sizes[1][1]);
        // System.out.println(sizes[2][0] + "  : " + sizes[2][1]);
        // System.out.println(sizes[3][0] + "  : " + sizes[3][1]);

        //(2) 배열 첫번째 요소들 순서대로 정렬 
        //30-70, 30-60, 40-80, 50-60
        Arrays.sort(sizes, (o1,o2)-> o1[0] - o2[0]); 
        
        for(int i = 0; i < sizes.length; i++){
            //[0]. [1] 번째 max 값 찾아내기
            if ( sizes[i][0] > max1){
                max1 = sizes[i][0];
            }
            if( sizes[i][1] > max2){
                max2 = sizes[i][1];
            }
        }
             
        return max1 * max2;
    }
}