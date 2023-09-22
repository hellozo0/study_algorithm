class Solution {
    public String solution(String s, int n) {
        String answer = "";
        //아스키코드 담을 변수
        int N = 0;
        
        for(int i = 0; i < s.length(); i++){
            N = s.charAt(i) + n;
            
            //공백
            if(s.charAt(i) == ' '){
                answer += s.charAt(i);
            } //대문자일때 연산 후 Z,z를 넘어갈 경우 -26(알파벳 개수)
            else if(s.charAt(i) < 91 && N > 90 || N > 122){
                N -= 26;
                answer += (char) N;
            } else{
                answer += (char) N;
            }
        }
        return answer;
    }
}