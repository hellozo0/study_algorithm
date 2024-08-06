import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //경우가 있음 false 
        Arrays.sort(phone_book);
        
//         for(int i = 0; i < phone_book.length; i++){            
//             //접 두 -->앞에 임
            
//             for(int j = i+1; j < phone_book.length; j++){
                
//                 String s = phone_book[j].substring(0, phone_book[i].length());
//                 if( s.equals(phone_book[i])) {
//                     answer = false; 
//                     break;
//                 }
//             }
//         } --> 효율성 탈락
        
        
        //반복문 2개는 시간 초과
        // for(int i = 0; i < phone_book.length; i++) {
        //     for(int j = 0; j < phone_book.length; j++){
        //         if( phone_book[i].length() < phone_book[j].length() && phone_book[j].startsWith(phone_book[i])) {
        //             answer = false; 
        //             break;
        //         }
        //     }
        // }
        
        for(int i = 0; i < phone_book.length-1; i++) {
            if( phone_book[i].length() < phone_book[i+1].length() && phone_book[i+1].startsWith(phone_book[i])) {
                    answer = false; 
                    break;
            }
        }
        
        return answer;
    }
}