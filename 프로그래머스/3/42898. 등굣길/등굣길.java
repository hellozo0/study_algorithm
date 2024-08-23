import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
     
        int[][] maps = new int[n+1][m+1];
        final int mod = 1000000007;
        
        for(int i = 0; i < puddles.length; i++) {
            maps[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        maps[1][1] = 1;
        
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=m; j++){
                if(maps[i][j] == -1) continue;
                
                if(maps[i-1][j] > 0) {
                    maps[i][j] += maps[i-1][j] % mod;
                }
                
                if(maps[i][j-1] > 0){
                    maps[i][j] += maps[i][j-1] % mod;
                }
                
            }
        }
        
        return maps[n][m] % mod;        
        
    }
}