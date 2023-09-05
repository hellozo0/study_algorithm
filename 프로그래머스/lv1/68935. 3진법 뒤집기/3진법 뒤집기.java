class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toString(n,3));
        sb = sb.reverse();
        answer = Integer.parseInt(sb.toString(),3); 
        
        return answer;
    }
}