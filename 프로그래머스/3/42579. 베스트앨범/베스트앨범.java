import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //먼저 누적합
        HashMap<String, Integer> sumMap = new HashMap<>();
        HashMap<String, Integer> countGenres = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            if( sumMap.containsKey(genres[i])){
                sumMap.put(genres[i], sumMap.get(genres[i])+plays[i]);
                countGenres.put(genres[i], countGenres.get(genres[i])+1);
            } else {
                sumMap.put(genres[i], plays[i]);
                countGenres.put(genres[i], 1);
            }
            // System.out.println("장르 : " + genres[i] + "노래번호 : " + plays[i]);
        } 
        
        //정답 배열크기 선언
        List<Integer> answer = new ArrayList<>();
        
        
        //Value 값 정렬  장르 순위매기기... ex- pop -> classic
        List<String> keys = new ArrayList<>(sumMap.keySet());
        Collections.sort(keys, (v1, v2) -> (sumMap.get(v2) - sumMap.get(v1)));
        
        // System.out.println("장르 순위 제대로 들어갔는지 : " + keys.get(0));  //pop
        // System.out.println("장르 순위 제대로 들어갔는지 : " + keys.get(1));  //classic
        
        // System.out.println("sumMap.size() : " + sumMap.size());
        // System.out.println(" countGenres.get(keys.get(0)) : " + countGenres.get(keys.get(0)) ); //2
        
        
        //map의 key 수가 총 장르의 개수...
        for(int i = 0; i < sumMap.size(); i++){
            
            //이제 배열에서 장르의 재생수 높은 음악들을 sort 해야함
            HashMap<Integer, Integer> genreMap = new HashMap<>();
            
            //먼저 pop ... 
            // for(int j = 0; j < countGenres.get(keys.get(i)); j++){ //여기가 잘못 되엇다 -> count 새야함..!
            for(int j = 0; j < genres.length; j++){ //여기가 잘못 되엇다 -> count 새야함..!
                if(genres[j].equals(keys.get(i))){ //장르 다 검색하면서 , pop이랑 같으면 1 4 이렇게 들어가야하는데..?
                    genreMap.put(j, plays[j]);
                    System.out.println("j : " +j + "plays[j] : " + plays[j]);
                }
            }
            //map에 1:600 4:2500 이렇게 저장되어 있을 것임.. 그러면 다시 정렬하기
            List<Integer> genreMapKeys = new ArrayList<>(genreMap.keySet());
            Collections.sort(genreMapKeys, (v1, v2) -> ( genreMap.get(v2) - genreMap.get(v1)));
            
            //2개만 넣기
            answer.add(genreMapKeys.get(0));
            if(genreMapKeys.size() > 1) {
                answer.add(genreMapKeys.get(1));
            }
        }
                
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}