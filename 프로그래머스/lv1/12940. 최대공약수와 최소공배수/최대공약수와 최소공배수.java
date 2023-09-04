class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        //구글링 -> 유클리드 호제법
        int min = (n < m)? n : m;
        int gcd = 0;
        
        for (int i = 1; i <= min; i++) {
			if (n % i == 0 && m % i == 0)
				gcd = i;
		}
        
        //(1) 최대 공약수 
        answer[0] = gcd;
        
        //(2) 최소공배수
        answer[1] = n * m / gcd;
       
        //최대 공약수 : n과 m의 약수를 나열해 공통된것 중에 가장 큰것
        //소인수분해 해서 겹치는 부분들 끼리 곱셈
     
        //최소 공배수 : 두수의 공배수 중에 공통된 것 중에 가장 작은것 
        //소인수분해 해서 지수가 큰것 x 공통되지 않는 소인수 끼리 곱셈
        
        return answer;
    }
}