import java.util.*;
class Solution {
    static String[] answer;
    static ArrayList<String> port;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        port = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if(s1[0].equals(s2[0])){
                    return s1[1].compareTo(s2[1]);
                }else
                    return s1[0].compareTo(s2[0]);
            }
        });
        
        
        
        dfs("ICN", 0, tickets);
        
        
        return answer;
    }
    
    public void dfs(String now, int n, String[][] tickets){
        if(answer[0] != null) return;
        
        if(n == tickets.length){
            port.add(now);
            answer = new String[n+1];
            
            for(int i = 0; i<port.size(); i++){
                answer[i] = port.get(i);
            }
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(visited[i]){
                continue;
            }
            if(tickets[i][0].equals(now)){
                port.add(now);
                visited[i] = true;
                
                dfs(tickets[i][1], n+1, tickets);
                visited[i] = false;
                port.remove(port.size()-1);
            }
        }
    }
}
