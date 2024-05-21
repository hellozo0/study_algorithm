
class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        
        for(int i = 0; i < s.length(); i++){
            
            if(!flag) {
                sb.append(Character.toUpperCase(s.charAt(i)));
                flag = true;
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            
            if(s.charAt(i) == ' '){
                flag = false;
            }
        }
        
        
        return sb.toString();
    }
}