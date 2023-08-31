import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int sum = 0;
        
        int[] newYearning = Arrays.copyOf(yearning, name.length);
        
        //yearning 배열 나머지 0으로 채우기 
        if (yearning.length != name.length){
            for(int i = 0; i <name.length-yearning.length;i++){
                newYearning[yearning.length + i] = 0;
            }
        }
        
        //각각 photo에 맞게 계산해서 result에 추가  
        for(int i = 0; i < photo.length;i++){ 
            for(int j = 0; j < photo[i].length; j++){
                //photo[i][j]가 name배열에 있는 요소랑 같다면 sum +하기
                for(int k = 0; k < name.length; k++){
                    if (photo[i][j].equals(name[k])){
                        sum += newYearning[k];
                    }
                }
            }
            answer[i] = sum;
            sum = 0;
        }
        
        return answer;
    }
}