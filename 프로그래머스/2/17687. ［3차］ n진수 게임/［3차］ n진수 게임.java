import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        int len = t * m;
        
        while(sb.length()<len) {
        	String temp = Integer.toString(num, n).toUpperCase();
        	sb.append(temp);
        	num++;
        }
        
        String str = sb.substring(0, len);
        
        for(int i=p-1; i<str.length(); i+=m) {
        	char ch = str.charAt(i);
        	answer.append(ch);
        }
        
        return answer.toString();
    }
}