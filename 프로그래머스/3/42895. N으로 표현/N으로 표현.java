import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) { // 0~8 
            dp.add(new HashSet<>());
        }
        
        //1개 쓰는 경우는 N 1번으로 초기화
        dp.get(1).add(N);
        
        for(int i = 2; i<=8; i++){
            //N을 sb에 추가
            StringBuilder sb = new StringBuilder().append(N);
            
            //반복문마다 N이어 붙이기 처음에는 X, 그다음부터는 N,NN, NNN, ...
            for(int j = 1; j < i; j++){
                sb.append(N);
            }
            //i번이면 예를들어 2면 NN 넣기
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            for (int j = 1; j < i; j++) {
                
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1+num2);
                        dp.get(i).add(num1-num2);
                        dp.get(i).add(num1*num2);
                        if( num2 != 0){
                            dp.get(i).add(num1/num2);
                        }
    
                    }
                }
            }
            if( dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}