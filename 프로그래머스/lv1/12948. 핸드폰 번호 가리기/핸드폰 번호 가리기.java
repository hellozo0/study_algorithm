class Solution {
    public String solution(String phone_number) {
        Integer phoneLen = phone_number.length();
        String answer = "";
        String lastAnswer = "";
        
        //substring 메소드로 문자열 자르기 
        lastAnswer = phone_number.substring(phoneLen-4,phoneLen);
        
        //문자열 곱하기는 repeat 사용
        answer = "*".repeat(phoneLen -4);
        
        answer = answer + lastAnswer;

        return answer;
    }
}