import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> input = new HashMap<>();
        
        for(int i = 0; i<participant.length; i++){
            input.put(participant[i], input.containsKey(participant[i]) ? input.get(participant[i])+1 : 1);
        }
        
        
        for(int i = 0; i<completion.length; i++){
            input.put(completion[i], input.get(completion[i])-1);
        }
        
        for(String s : input.keySet()){
            if(input.get(s)!=0)
                answer += s;
        }
        return answer;
    }
}
