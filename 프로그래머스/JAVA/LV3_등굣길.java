import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] Case = new int[n][m];
        int[][] pongdang = new int[n][m];
        
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                pongdang[i][j]=1;
            }
        }
        
        for(int i=1; i<n; i++){
            Case[i][0]++;
        }
        for(int i=1; i<m; i++){
            Case[0][i]++;
        }
        
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            pongdang[y-1][x-1] = 0;
            //pongdang[y-1][x-1] = 1;
            Case[y-1][x-1] = 0;
        }
        
        for(int i=1; i<m; i++){
            if(pongdang[0][i]==0){
                for(int j = i; j<m; j++){
                    Case[0][j] = 0;
                }
                break;
            }
        }
        
        for(int i=1; i<n; i++){
            if(pongdang[i][0]==0){
                for(int j = i; j<n; j++){
                    Case[j][0] = 0;
                }
                break;
            }
        }
        
        
        if(m==1){
            if(puddles.length>0)    return 0;
            return 1;
        }    
        if(n==1){   
            if(puddles.length>0)    return 0;
            return 1;
        }
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                Case[j][i] = pongdang[j][i]*((Case[j-1][i]+ Case[j][i-1])%1000000007);
                //if(pongdang[j][i]==1) Case[j][i]=0;
               // else Case[j][i] = (Case[j-1][i]+ Case[j][i-1])%1000000007;
            }
        }
        
        answer = Case[n-1][m-1];
        return answer;
    }
}
