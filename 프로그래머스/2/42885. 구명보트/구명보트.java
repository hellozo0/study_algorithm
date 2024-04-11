import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        //앞에서 부터 세트를 묶는다는 생각X, min, max를 세트로 묶어서 처리하면 더 효율적
        //뒤에서 부터 시작
        //50(min) 50 70 80(max)
        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}