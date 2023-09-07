import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] sArray = s.split("");
        
        //maps 써야할듯?
        Map<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < sArray.length; i++){
            
            // (1) 그리고 해당 문자가 숫자면 append  >= 0 <= 9 인지 비교했는데 이게 string을 숫자로 변환 못해서 에러인듯
            if( map.containsValue((int)sArray[i].charAt(0) - 48)){
                answer.append(sArray[i]);
            } else{ //(2) 해당 문자가 문자면 누적합하는 곳에 누적합
                sb.append(sArray[i]);
            }
            
            //(3) 만약 누적합한 해당 문자열 누적합이 map에 있으면 append하고 sb 초기화
            if(map.containsKey(sb.toString())){                
                answer.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
                        
        }
        
        return Integer.parseInt(answer.toString()); //StringBuilder를 int로 변환
    }
}