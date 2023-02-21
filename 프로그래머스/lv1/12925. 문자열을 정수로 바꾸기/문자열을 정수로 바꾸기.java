class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 문자열 중에 맨 앞부분(부호)를 잘라서 따로 저장 해야하는줄..?
        // + 오면 + 제외한 뒷 부분을 숫자로 변환
        // - 오면 - 제외한 뒷 부분을 숫자로 변환
        // 부호가 안오면 그냥 숫자로 변환
        answer = Integer.parseInt(s);
        return answer;
    }
}