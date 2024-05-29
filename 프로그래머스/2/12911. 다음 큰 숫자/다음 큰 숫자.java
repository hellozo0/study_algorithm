class Solution {
        
    public int solution(int n) {
        int answer = n+1;        
        int count = 0; 
        
        String binary = Integer.toBinaryString(n);
        count = countOne(binary);
        
        while(true) {
            binary = Integer.toBinaryString(answer);
            if(count == countOne(binary)) {
                break;
            } else {
                answer ++;
            }
        }
        
        return answer;
    }
    
    static private int countOne(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }
}