import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();
        
        //1. yellow 소인수 분해 
        //예를 들어 24 ->   1 x 24 , 2 x 12 , 3 x 8 , 4 x 6
        //       2 + (^24^ +2)*2, 4 + (^12^ + 2) * 2 , 2*^3^
        
        //2. 소인수 분해한 쌍을 오름차순 정렬
        //작은 수 a, 큰수 b 라고 하자
        //2*a + (b+2) * 2의 답이 brown이랑 같은지 확인해서 같으면 정답
        //12 = 1 x 12(x), 2 x 6, 3 x 4 ==>  
        //13 -> 1 ~6
        // 넓이 = yellow + brown 
        
        //1,2는 불가
        
        //24 -> 3 x 8 , 4 x 6
                // brown 8 x 2 + (3-2) * 2 = 16 + 2 = 18
                // yellow (3-2) * (8-2) = 6]
        //12 - 1 x 12, 2 x 6, 3 x 4
        int area = yellow + brown; // 12
        
        for(int i= 3; i < area/2; i++){ //3 ~ 6
            int quotient = 0;
            int division = 0;
            if(area % i == 0){ //나누어 떨어지면
                quotient = area / i ; // 3
                division = area / quotient ; // 4
                if(division * 2 + (quotient-2) * 2 == brown) {
                    if( (quotient-2) * (division-2) == yellow){
                        answer.add(quotient);
                        answer.add(division);
                        break;
                    }
                }

            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}