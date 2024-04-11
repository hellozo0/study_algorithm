import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] array = new int[n];        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            array[i] = 1;
        }
        for(int i = 0; i < lost.length; i++){
            array[lost[i]-1] -= 1;
        }
        for(int i = 0; i < reserve.length; i++){
            array[reserve[i]-1] += 1;
        }
        
        System.out.println(Arrays.toString(array));
        //lost를 기준으로 검색하기 ,2 4 이런것들은 앞에 애들이 주면 제일 best 
        //따라서 배열을 하나 만들고 
        //1 2 3 4 5
        //기본 세팅을 1로 하고
        // reserve면 +1. lost면 -1
        //2 0 2 0 2
        //2 0 2 0 0
        //1 0 2 0 0
        
        for(int i = 0; i < n; i++){
            //0인 경우 다음 으로 넘어가기
            if( array[i] == 0) continue;
            
            //2개 가져왔는데 앞에 있는애 빌려 줄 수 있는 경우 [0,2] 상태 인 경우
            if(i != 0 && array[i] == 2 && array[i-1] == 0){
                array[i] = 1;
                array[i-1] = 1;
                count += 2;
                continue;
            }
            //2개 가져왔는데 뒤에 있는애 빌려 줄 수 있는 경우 
            if( i != n-1 && array[i] ==2 && array[i+1] == 0){
                array[i] = 1;
                array[i+1] = 1;
                count++;
                continue;
            }
            
            //그냥 1개 인애
            if( array[i] != 0) count++;
        }
        
        return count;
    }
}