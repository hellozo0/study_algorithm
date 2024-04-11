import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        
        int[][] way = new int[n+1][m+1];
        
        for(int[] puddle : puddles){
            way[puddle[1]][puddle[0]] = -1;
        }
        way[1][1] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                //1. 웅덩이 일 경우 continue;
                if( way[i][j] == -1) {
                    continue;
                }
                //왼쪽이 웅덩이일 경우 i j 기준
                if( way[i-1][j] > 0) {
                    way[i][j] += way[i-1][j] % mod;
                }
                //위에가 웅덩이일 경우 i j 기준
                if( way[i][j-1] > 0) {
                    way[i][j] += way[i][j-1] % mod;
                }
                
            }
        }
        
        return way[n][m] % mod;
    }
}