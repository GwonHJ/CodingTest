import java.util.*;

class Words{
    String word;
    int root;
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int count = 0;
        Words w = new Words();
        Queue <Words> q = new LinkedList<Words>();
        int[] distance = new int[50];
        
        w.word = begin;
        w.root = 0;
        q.add(w);
        //System.out.println(q.peek().word+" "+q.peek().root);
        
        String here;
        int r_node;
        
        while(!q.isEmpty()){
            w = q.poll();
            here = w.word;
            r_node = w.root;
            //System.out.println(w.word+" "+r_node+" "+distance[r_node]);
            
            for(int i = 0; i<words.length; i++){
                if(begin.equals(words[i]))  continue;
                if(i!=0 && i == r_node)   continue;
                if(distance[i] != 0) continue;
                for(int j = 0; j<begin.length(); j++){
                    if(here.charAt(j) != words[i].charAt(j)){
                        count++;
                    }
                    if(count > 1)   break;
                }
                if(count <= 1){
                    w.word = words[i];
                    w.root = i;
                    q.add(w);
                    distance[i] = distance[r_node]+1;
                    System.out.println(w.word+" "+i+" "+distance[i]);        
                }
                if(target.equals(w.word))  return distance[r_node]+1;
                count = 0;
            }
        }
        return answer;
    }
}
