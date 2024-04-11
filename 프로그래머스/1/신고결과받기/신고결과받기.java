package Programmers.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        //reportHash : id_list에 해당하는 HashSet , HashSet은 중복이 제거가 된다. [신고한 사람 : 신고당한 사람]
        HashMap<String, HashSet<String>> reportHash = new HashMap<String, HashSet<String>>();
        
        //count : report에서 신고당한 횟수를 정의함 [신고당한 사람 : 신고당한 횟수]
        HashMap<String, Integer> countHash = new HashMap<String, Integer>();
        
        //정답을 담을 배열
        int[] answer = new int[id_list.length];
        
        
        // 1. 이용자의 ID 가 담긴 문자열 배열  Hash에 추가
        for(String id:id_list) {
        	reportHash.put(id, new HashSet<String>());
        	countHash.put(id, 0);
        }
        
        
        // 신고 당한 이용자의 ID 정보가 담긴 문자열 배열
        for(String s:report) {
            // report 배열의 형태를 보게 되면 띄어쓰기로 아이디를 구분해서 하나하나씩 가져온다. 
        	String[] str = s.split(" ");
            
            // 신고한 사람이 이미 신고할 사람을 신고했는지 체크
        	// if(!reportHash.get(str[0]).contains(str[1])) {
                
                //cnt는 countHash에 해당 [1]번째 사람의 신고횟수값
        		int cnt = countHash.get(str[1]);
                
                // countHash에 신고받은 횟수 +1
            	countHash.put(str[1], cnt+1);
                
                //[0]를 신고한 사람 목록에 [1]추가 
            	reportHash.get(str[0]).add(str[1]);
        	// }
        }
        
        //유저가 신고한 사람들 중에 몇명이 정지 되었는지 answer에 넣기
        for(int i=0;i<id_list.length;i++) {
        	int cnt = 0;
        	for(String id:reportHash.get(id_list[i])) {
        		if(countHash.get(id) >= k) {
        			cnt++;
        		}
        	}
        	answer[i] = cnt;
        }
        
        //결과 출력
        return answer;
    }
        
}