import java.util.*;

class Solution {
    class Trie{
        /*
        LenMap의 역할
        key는 삽입된 문자열의 길이, value는 해당 길이의 문자열의 개수
        => 해당 노드까지 도달할 수 있는 문자열의 수를 구할 수 있다
        */
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        HashMap<Character,Trie> child = new HashMap<>();
        
        Trie(){
            
        }
        
        public void insert(String word){
            Trie trie = this;
            int len = word.length();
            lenMap.put(len, trie.lenMap.getOrDefault(len,0)+1); 
            //없다면 0이 가져올테니 +1, 하고 있다면 그 값 +1
            
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                
                trie.child.putIfAbsent(c,new Trie());
                trie = trie.child.get(c);
                trie.lenMap.put(len, trie.lenMap.getOrDefault(len,0)+1); 
            }
        }
        
        /*
        이제 fro?? 형태의 경우 
        i = 0일때 부터
        f가 있으면 f의 자식 노드를 find 한다 i+1하고 재귀로 
        */
        public int find(String word, int i) {
            char c = word.charAt(i);
            if(c == '?') { 
                return lenMap.getOrDefault(word.length(),0);
            } 
            return child.get(c) == null ? 0 : child.get(c).find(word,i+1);
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie front = new Trie();
        Trie back = new Trie();
        
        //1. 일단 트라이에 다 넣고 
        for(String word : words){
            front.insert(word);
            back.insert(reverse(word));
        }
        
        //2. 접두 인지 접미인지에 따라 다르게 동작
        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            
            if(query.charAt(0) == '?') { //?를 맨뒤로 옮긴다
                answer[i] = back.find(reverse(query),0);
            } else {
                answer[i] = front.find(query,0);
            }
        }
        return answer;
    }
    
    public String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
}
