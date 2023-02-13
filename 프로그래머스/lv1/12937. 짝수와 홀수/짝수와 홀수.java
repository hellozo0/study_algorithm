class Solution {
    public String solution(int num) {
        String answer = "";
        
        // answer = (num % 2 == 1)? "Odd": "Even"; 
        // 테스트 실패 원인 : 자릿수가 너무 커서....? 2,147,483,647
        
        
        if ( num % 2 == 0 ){
            answer = "Even";
        } else {
            answer = "Odd";
        }
        
        //아래꺼 돌리면 실패
        // if ( num % 2 == 1) {
        //     answer = "Odd";
        // } else {
        //     answer = "Even";
        // }
        
        return answer;
    }
}