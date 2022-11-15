package Programmers.Level2;

import java.util.*;

class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        
        //toString(n,k) --> n진수를 k진수로 바꿔줌
        String num = Integer.toString(n, k);
        
        //0을 기준으로 나눠서 배열에 넣기
        String[] num_array = num.split("0");

        //배열 요소 반복
        for(String s:num_array){
            //예외처리, 빈 값이면 continue
            if(s.equals("")) {
                continue;
            }
            
            //String을 long타입으로 변환 (int는 안대용 -> n 이 1,000,000일 수 있으니까)
            long number = Long.parseLong(s);
            
            //소수 판별여부
            if(isPrime(number)){
                answer++;
            }
        }
        return answer;
    }
    
    
    //Prime인지 판단하는 함수 true or false
    public static boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        
        if(num == 2) return true;
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
}
