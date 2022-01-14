class Solution {
    
    boolean[] visited = new boolean[200];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i<n; i++){
            if(visited[i]==true)   continue;
            answer++;
            dfs(i,n,computers);
        }
        return answer;
    }
    
    public void dfs(int here,int n, int[][] computers){
        visited[here] = true;
        for(int i = here; i<n; i++){
            if(computers[here][i] == 1){
                if(visited[i]==true)    continue;
                dfs(i,n,computers);
            }
        }
        return;
    }
}
