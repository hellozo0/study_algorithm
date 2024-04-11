import java.util.*;

class Solution {
    
    static boolean visited[];
    static ArrayList<String> airport;
    
    public String[] solution(String[][] tickets) {
        //선언
        visited = new boolean[tickets.length];
        airport = new ArrayList<>();
        
        DFS("ICN","ICN", tickets, 0); //시작은 무조건 ICN
        
        Collections.sort(airport);
        return airport.get(0).split(" ");
    }
    
    static void DFS(String start, String next, String[][] tickets, int count){
        //1. 끝까지 다 갔을 떄 
        if(count == tickets.length){
            airport.add(next);
            return;
        }
        
        //2. 방문하지 않은 곳이고, 시작지점에 tickets에 있으면
        for(int i = 0; i < tickets.length; i++){
            if (!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                DFS(tickets[i][1], next + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}

