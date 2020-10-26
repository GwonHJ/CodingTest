import java.util.*;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i<N; i++){
	        int n = (100-progresses[i])/speeds[i];
	        int mod = (100-progresses[i])%speeds[i];
	        if(mod != 0)    n++;
	        q.add(n);
	    }
        int now = q.peek();
	    while(q.size()!=0){
	        if(now >= q.peek()){
	            count++;
	        }
	        else{
	            answer.add(count);
	            count = 1;
	            now = q.peek();
	        }
	        q.remove();
	    }
	    answer.add(count);
        return answer;
    }
}
