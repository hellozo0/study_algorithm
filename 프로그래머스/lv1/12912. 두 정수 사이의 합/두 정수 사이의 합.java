class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        //반복문의 개수를 줄이는 방법이 최선의 방법이다 --> 처음 a < b 형태가 되도록 temp 써서 변환 한 후 1개의 for문 사용하기
        if ( b > a){
            for(int i = a; i <= b; i++){
               answer += i;
            }
        } else {
            for(int i = a; i >= b; i--){
                answer += i;
            }
        }
        return answer;
    }
}