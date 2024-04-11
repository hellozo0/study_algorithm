class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        //연달아 털기 불가능 0인덱스랑 length-1 인덱스도 털기 X
        //최대값
        
        // 처음 집 훔치고 마지막집을 훔치지 못하는 case와 , 그렇지 않은 케이스
        int[] case1 = new int[money.length];
        int[] case2 = new int[money.length];
        // case1은 Dp를 위해 0,1번 값을 모두 처음집값으로 셋팅
        case1[0] = money[0];
        case1[1] = money[0];
        //case2는 처음집을 안훔치므로 0값으로 셋팅
        case2[0] = 0;
        case2[1] = money[1];
        // DP - -2번째에 지금값을 더한것과 -1번째 집까지 훔친 경우를 비교하면서 어느집을 훔치는게 제일 큰지 합계를 저장
        for(int i=2; i<money.length; i++){
            case1[i] = Math.max(case1[i-2] + money[i], case1[i-1]);
            case2[i] = Math.max(case2[i-2] + money[i], case2[i-1]);
        }
        // 두 경우중 더 많이 훔치는 경우를 반환 
        //case1은 첫집을 턴경우이므로 마지막집은 접근하지않는다, len-2번째 인덱스와 비교
        answer = Math.max(case1[money.length-2], case2[money.length-1]);

        return answer;
        
    }
}