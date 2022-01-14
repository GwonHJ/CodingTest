import java.util.*;
import java.io.*;

class Job implements Comparable<Job>{
    int come;
    int time;
    public Job(int come, int time){
        this.come = come;
        this.time = time;
    }
    
    @Override
    public int compareTo(Job job){
        if(this.time < job.time){
            return -1;
        }else if(this.time == job.time){
            if(this.come < job.come)
                return -1;
        }
        return 1;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int end_time = 0;
        int sum = 0;
        int cnt = 0;
        int idx = 0;
        
        while(cnt < jobs.length){
            
            while(idx < jobs.length && jobs[idx][0] <= end_time){
                pq.add(new Job(jobs[idx][0], jobs[idx++][1]));
            }
            if(pq.isEmpty()){
                end_time = jobs[idx][0];
            }else{
                Job now = pq.poll();
                sum += now.time + end_time-now.come;
                end_time += now.time;
                cnt++;
            }
           
        }
        answer = sum/jobs.length;
        
        return answer;
    }
}
