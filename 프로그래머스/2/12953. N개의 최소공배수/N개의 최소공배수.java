class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int g = 0;
                    
        if(arr.length > 1) { 
            for(int i = 1; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }

        return answer;
    }

    //최대 공약수 구하는 함수
    private static int gcd(int a, int b) {
        int num = a % b;
        if(num == 0) return b;
        else return gcd(b, num);
    }
        
}