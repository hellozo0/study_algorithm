class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String letter = Integer.toString(n,k);
        String[] letters = letter.split("0");
        
        for( String a : letters) {
            if(a.equals("")) continue;
            if(isPrime(Long.parseLong(a)) ) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(Long num) {
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if( num % i == 0) return false;
        }
        
        return true;
    }
}
    