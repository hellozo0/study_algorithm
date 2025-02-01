class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        //연달아 털기 불가능 0인덱스랑 length-1 인덱스도 털기 X
        //최대값
        
        // 0번째 ㅇ, 0번쨰 X
        int[] house0 = new int[money.length];
        int[] house1 = new int[money.length];
        
        // 처음집(0번쨰) 터는 경우 - 처음 집 값 세팅
        house0[0] = money[0];
        house0[1] = money[0];
        
        //처음 집 값 안 턴 경우 - 0값으로 셋팅
        house1[0] = 0;
        house1[1] = money[1];
        
        // DP 
        for(int i=2; i<money.length; i++){
            house0[i] = Math.max(house0[i-2] + money[i], house0[i-1]);
            house1[i] = Math.max(house1[i-2] + money[i], house1[i-1]);
        }
        
        //house0은 마지막집 X 범위까지 최대값
        answer = Math.max(house0[money.length-2], house1[money.length-1]);

        return answer;
        
    }
}