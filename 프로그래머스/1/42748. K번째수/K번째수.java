import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++){
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];
            int count = 0;
            for(int j = commands[i][0]-1; j < commands[i][1]; j++){
                temp[count++] = array[j]; // 들어갔음
            }
            // Collection.reverseOrder();
            Arrays.sort(temp);
            
            answer.add(temp[commands[i][2]-1]);
            
            // temp.clear();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}