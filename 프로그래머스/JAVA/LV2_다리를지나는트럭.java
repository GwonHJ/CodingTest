import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q= new LinkedList<Integer>();
    
        int sum = 0; int index = 0;
        
        
        while(index<truck_weights.length){
        if(weight>=sum+truck_weights[index]){
            sum += truck_weights[index];
            q.add(truck_weights[index]);
            index++;
        }
        else q.add(0);//탑승 못하면 지금 다리에 0을 추가
        if(q.size()>=bridge_length){
            sum -= q.poll();//제일앞에 있는 무게 빼주기
        }
        answer++;
        
    }
    answer += bridge_length;
    
        return answer;
    }
}
