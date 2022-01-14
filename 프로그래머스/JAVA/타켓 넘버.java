import java.util.*;

class Solution {
    static boolean[] checked;
    static int N, answer, T;
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        T = target;
        checked = new boolean[N];
        
        make(0,numbers);
        
        return answer;
    }
    public static boolean isPossible(int[] numbers){
        int sum = 0;
        for(int i = 0; i<N; i++){
            if(checked[i]){
                sum += numbers[i];
            }else{
                sum -= numbers[i];
            }
        }
        if(sum == T)
            return true;
        else
            return false;
    }
    public static void make(int step, int[] numbers){
        if(step == N){
            if(isPossible(numbers))
                answer++;
            return;
        }
        checked[step] = true;
        make(step+1,numbers);
        checked[step] = false;
        make(step+1,numbers);
    }
}
