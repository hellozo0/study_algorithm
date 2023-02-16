class Solution {
    public long solution(long n) {
        long answer = 0;
        
//         long i = 1;
//         while ( i <= (n/2) ) {
//             if (n == (i * i)) {
//                 answer = (i+1)*(i+1);
//                 break;
//             }
//             i++;
//         }
        
//         if (answer == 0) {
//             answer = -1;
//         }
        
        
        //Math 사용
        long m = (long)Math.sqrt(n);
        
        if (n == Math.pow(m,2)){
            answer = (long)Math.pow(m+1,2);
        } else {
            answer = -1;
        }

        return answer;
    }
}