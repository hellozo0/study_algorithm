import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            if(map.containsKey(participant[i])){
                map.replace(participant[i], map.get(participant[i])+1);
            } else {
                map.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            if( map.get(completion[i]) != 1){
                map.replace(completion[i], map.get(completion[i])-1);
            } else {
                map.remove(completion[i]);
            }
        }
        
        String answer = "";
        
        for(String key : map.keySet() ){
            answer = key;
        }
        
        return answer;
        
        // map.forEach((key, value) -> {
        //     return key;
        // });
    }
}