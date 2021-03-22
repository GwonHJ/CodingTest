import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int N = clothes.length;
        Map <String, Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
            else
                map.put(clothes[i][1], 1);
        }
        
        answer = 1;
        for(String k : map.keySet()){
            answer *= map.get(k)+1;
            // System.out.println(answer);
        }
        return answer-1;
    }
}
