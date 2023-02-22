class Solution {
    public long solution(long n) {
        String answer = "";
        
        String str = Long.toString(n);
        
        int[] arr = new int[str.length()];
        
        //substring : 문자열 자르기
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i,i+1);
            arr[i] = Integer.parseInt(s);
        }
        
        //내림차순 정렬
        for(int j = 0; j < str.length()-1; j++){
            for(int i = 0; i < str.length()-1; i++) {
                if (arr[i] < arr[i+1]) {
                    int tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        
        //문자열 합치기
        for(int i = 0; i < str.length(); i++) {
            answer += arr[i];
        }
        
        return Long.parseLong(answer);
    }
}