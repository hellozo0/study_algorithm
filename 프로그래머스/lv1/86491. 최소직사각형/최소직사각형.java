import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        // 2차원 배열의 가장 큰게 첫번째 요소에 오도록 정렬 
        // 그리고 첫번쨰 요소중에 가장 큰수
        //두번째 요소들 중에 가장 큰수들을 곱해서 result 리턴
        

        //(1) 배열 내부 먼저 정렬
        for(int i = 0; i < sizes.length; i++){
            Arrays.sort(sizes[i]); // 2채원 배열 정렬
        }

        //(2) 배열 첫번째 요소들 순서대로 정렬 
        Arrays.sort(sizes, Comparator.comparingInt(num1 -> num1[0]));

        
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