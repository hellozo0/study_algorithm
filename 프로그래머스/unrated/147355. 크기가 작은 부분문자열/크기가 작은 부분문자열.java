class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        //문자열 자르기 하나하나 - StringTokenizer, StringBuilder로는 어떻게? 
        String[] tArray = t.split("");
        
        for(int i = 0; i < tArray.length - p.length() + 1; i++){
            
            int count = i; //첫자리수 인덱스 
            double tNum = 0; //비교할 문자
            
            for(int j = p.length(); j > 0; j--){
                tNum += Double.parseDouble(tArray[count++]) * Math.pow(10,j-1);
            }
            
            if (tNum <= Double.parseDouble(p)){
                answer++;
            }
        }
        
        return answer;
        
    }
}