class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] letter = s.split("");
        int countP = 0;
        int countY = 0;
        
        //문자열을 비교할때는 == 연산자가 아니라 .equals를 사용해서 비교한다.
        for (int i = 0; i < letter.length; i++){
            if ((letter[i].equals("p")) || (letter[i].equals("P"))){
                countP++;
            }
            else if ((letter[i].equals("y")) || (letter[i].equals("Y"))){
                countY++;
            }            
        }
        
        //3항 연산자를 사용해 조건문의 길이를 단축 시킨다.
        answer = (countP == countY)? true : false;

        System.out.println(countP + "  : "  + countY);
        return answer;
    }
}