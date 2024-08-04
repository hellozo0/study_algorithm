import java.util.*;

class Solution {
    
    static String str1;
    static String str2;
    static ArrayList<String> str1List;
    static ArrayList<String> str2List;
    
    public int solution(String str1, String str2) {
        
        //대문자로 다 만들어 버리기
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        //List로 다중집합 정리
        str1List = new ArrayList<>();
		str2List = new ArrayList<>();

        //최종 담을 것들
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

        //1. 다중집합 메소드
        multi(str1, str1List);
        multi(str2, str2List);
        
        //예외처리
        if (str1List.isEmpty() && str2List.isEmpty()) {
            return 65536;
        }
        
        //정렬
        Collections.sort(str1List);
		Collections.sort(str2List);
        
        //2. 교집합 처리 
		for(String s : str1List) {
			if(str2List.remove(s)) { 
				intersection.add(s); //str2List에 겹치는 요소가 있으면 교집합에 넣기, 그리고 삭제욤 ( 짝 맞추기)
			}
			union.add(s);
		}
		
		//3. 합집합 처리 
		for(String s : str2List) { // 나머지 2에 있던것 합집합에 넣기
			union.add(s);
		}
        
		//유사도 구하기 
		double a = intersection.size();
		double b = union.size();

   		double jakard = 0;
		jakard = (double) intersection.size() / (double) union.size();

		return (int) (jakard * 65536);
    }
    
    static public void multi(String str, ArrayList<String> strList){
        for(int i = 0; i < str.length()-1; i++) {
			char first = str.charAt(i);
			char second = str.charAt(i+1);

            //문자일 경우만 
			if(Character.isLetter(first) && Character.isLetter(second)) {
				strList.add(Character.toString(first) + Character.toString(second));
			}
		}
    }
}