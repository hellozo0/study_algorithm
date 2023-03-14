// 꼭 알아야 할것 : 문자열 요소 자르기 
// String.substring(start,end) - 문자열  start위치 부터 end전까지 문자열 발췌
// String[] array = str.split("#"); - String값을 특수기호로 끊어서 배열에 저장


class Solution {
    public String solution(String s) {
        String answer = "";
        
        if (s.length() % 2 == 0){ //(s.length()/2) -1 , (s.length()/2) 2가지!
            answer = s.substring((s.length()/2) -1, (s.length()/2)+1);
        } else {  // s.length/2 1가지!
            answer = s.substring(s.length()/2, (s.length()/2)+1);
        }
        
        return answer;
    }
}