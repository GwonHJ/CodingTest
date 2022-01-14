import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue <Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        
        for(int node = 0; node<n; node++){
            if(visited[node])
                continue;
            q.add(node);
            while(!q.isEmpty()){
                int now = q.poll();

                for(int i = 0; i<computers[now].length; i++){
                    if(visited[i]||computers[now][i]==0)
                        continue;
                    visited[i] = true;
                    q.add(i);
                }
            } 
            answer++;
        }
        
        return answer;
    }
}
