class Solution {
    public int solution(String name) {
        int answer = 0;
        
//         //완료한 문자의 개수 새는 변수
//         int count = 0;
        
//         //방향성 변수 (N : Next, B : Back)
//         char direction = 'N';
        
//         //인덱스
//         int index = 0;
        
//         //다 완료하면 탈출~ complete 개수랑 length가 같아야함
//         while (count != name.length() && index >= 0 && index < name.length()){
//             char letter = name.charAt(index);
            
//             if( letter == 'A') count++; 
            
//             if( )
//             //A면 count++
//             //다음꺼 : name.length() 랑 같으면 안된다 
            
//         }
        
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int minMove = length - 1; // 좌우 움직임 수를 체크
        
        for(int i = 0; i < length; i++){
            //(1) 해당 숫자를 움직이는 수(up으로) 
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            
            // 연속되는 A 갯수 확인 만약 JAAAAAAAAAAN이라면 index는 11로 끝남
            //만약 JAAAAAACAAAN 이면 index는 7
            //    AAAJAAACAAAN i = 3, index = 7
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            minMove = Math.min(minMove, i + i + length - index);
            
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려
            //이 부분 어렵다 x2는 뒤로 갔다가 앞으로 다시 가야하니까 x2 하고 원래의 index i 
            minMove = Math.min(minMove, (length - index) * 2 + i); 
        }
        return answer + minMove;
    }
}