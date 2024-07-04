//[18주차] JAVA : n^2 배열 자르기

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        // right - left < 10^5 니까 int화 해도 OK
        int answerIndex = (int)(right - left + 1);
        
        int[] answer = new int[answerIndex];
        long hang,yeol;
        
        for(int i = 0; i < answerIndex; i++){
            hang = (left / n) + 1;
            yeol = (left % n) + 1;
            answer[i] = (int)(hang <= yeol? yeol : hang);
            left ++;
        }
        
        // int[] nnArray = new int[n*n];
//         int hang,yeol;
        
//         for(int i = 0; i < n*n; i++){
//             hang = (i / n) + 1; 
//             yeol = (i % n) + 1; 
//             nnArray[i] = (hang <= yeol ? yeol : hang);
//         }
        
        // (1)  
        // for(int i = 0; i < right-left+1; i++){
        //     answer[i] = nnArray[(int)left+i];
        // }
        
        // (2) answer = Arrays.copyOfRange(nnArray, (int)left, (int)right+1);    
        return answer;
    }
}