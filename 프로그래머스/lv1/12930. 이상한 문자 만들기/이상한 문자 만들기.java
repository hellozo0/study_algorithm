
class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer(); // 문자열 이어 붙일 곳
        
        int count = 0; //짝 홀 카운트하는 변수 - 공백을 만나면 초기화해야함
        for(int i = 0; i < s.length(); i++){
            
            if(count % 2 == 0 && s.charAt(i) != ' '){
                sb.append(Character.toUpperCase(s.charAt(i))); //대문자를 넣는다
            } else{
                sb.append(Character.toLowerCase(s.charAt(i))); //소문자를 넣는다 - 혹시나 입력문자가 대문자일 상황 대비
            }
            count++;
            
            if(s.charAt(i) == ' '){
                count = 0;
            }
            
        }
        
        return sb.toString();
        
    }
}