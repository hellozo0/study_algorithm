import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while((n / 10) != 0){            
            answer += n % 10;
            n = n / 10;
        }
        
         answer += n;
        
        //더 좋은 방법 1
        // while ( n != 0) 을 사용해서 answer += n ; 을 빼는 방법!

        return answer;
    }
}
