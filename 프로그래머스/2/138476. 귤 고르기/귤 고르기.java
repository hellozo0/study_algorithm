import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
            
        Arrays.sort(tangerine); // 1,2,2,3,3,4,5,5
        Map<Integer, Integer> map = new HashMap<>();
        
        //Map에 넣음
        for(int i = 0; i < tangerine.length; i++){
            
            if(map.containsKey(tangerine[i])){
                map.replace(tangerine[i], map.get(tangerine[i])+1);
            } else {
                map.put(tangerine[i],1);
            }
        }
         
        //1은 1개, 2는 2개, 3은 2개, 4는 1개, 5는 2개 -> 2,2,2,1,1 로 다시 배열에 넣음
        //빈도수 대로 다시 추리고, 배열에 넣어서 내림차순
        Integer[] group = new Integer[map.size()];
        int index = 0;
        for(Integer value : map.values()){
            group[index++] = value;
        }
        
        Arrays.sort(group, (o1, o2) -> o2-o1);
        
        //진짜 로직 몇개 되는지 카운트
        for(int i = 0; i < group.length; i++){
            k -= group[i];
            if(k <= 0) {
                answer = i + 1;
                break;
            }
        }
        
        
        return answer;
    }
}