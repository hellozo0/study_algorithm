import java.util.*;

class Solution {
    
    static char[] number;
    static boolean[] visited;
    static Map<Integer,Integer> map;
    
    public int solution(String numbers) {
        int answer = 0;
        number = numbers.toCharArray();
        visited = new boolean[number.length];
        map = new HashMap<>();
        
        for(int i = 1; i <= number.length; i++){
            permutation(number, 0, number.length, i);
        }
        
        answer = map.size();
        
        return answer;
    }
    
    
    // 순열 구하기 n : 배열의 길이, r : 조합의 길이
    static void permutation(char[] number, int depth, int n, int r) {
        if (depth == r) {
            makePrime(number, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(number, depth, i);
            permutation(number, depth + 1, n, r);
            swap(number, depth, i);
        }
    }

    static void swap(char[] number, int depth, int i) {
        char temp = number[depth];
        number[depth] = number[i];
        number[i] = temp;
    }
    
    static void makePrime(char[] number, int r){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(number[i]);
                System.out.print(number[i]);
        }
        
        Integer result = Integer.parseInt(sb.toString());
        if(isPrime(result)) map.put(result,1);
        
        System.out.println();
    }
    
    static boolean isPrime(int n){ // 시간복잡도 O(N)
        if(n < 2){
            return false; // 1은 소수가 아니기에 false
        } else{
            for(int i = 2; i < n; i++){
                if(n % i == 0) return false; // 나머지연산을 했을 때 0이 나오면 소수가 아니므로 false
            }
            return true; // 위의 case
        }
    }
}