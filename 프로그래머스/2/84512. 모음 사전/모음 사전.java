import java.util.*;

class Solution {
    
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list;
    // static int num = 0;
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        
        //다 저장하기
        dfs("",0);
        
        return list.indexOf(word);
        
    }
    
    private static void dfs(String s, int length){
        if(length > 5) return;
        
        list.add(s);
        
        // System.out.println("num : " + num + ", s : " + s + "------");    
        // num++;
        for(int i = 0; i < 5; i++){
            dfs(s + alphabet[i], length+1);
        }
        
    }
    
}