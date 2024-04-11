import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        //1번 12345 5size씩 반복
        //2번 21232425 8size씩 반복
        //3번 3311224455 10size씩 반복
        int[] math1 = {1,2,3,4,5};
        int[] math2 = {2,1,2,3,2,4,2,5};
        int[] math3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = {0,0,0};
        
        for(int i = 0; i < answers.length; i++){
            int answer1 = i % 5;
            int answer2 = i % 8;
            int answer3 = i % 10;
            
            if(answers[i] == math1[answer1]) count[0]++;
            if(answers[i] == math2[answer2]) count[1]++;
            if(answers[i] == math3[answer3]) count[2]++;
        }
        
        //count이제 비교하기....
        int maxCount = Math.max(count[0], Math.max(count[1], count[2]));
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(maxCount == count[i]){
                list.add(i+1);
            }
        }
         
        //가장 높은 점수를 받은 사람이 여럿일 경우, 오름차순 정렬
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}