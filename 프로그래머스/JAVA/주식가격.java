import java.util.Stack;
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        for(int i = 0; i< N; i++){
            for(int j = i+1; j<N; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
                else
                    answer[i] = j-i;
            }
        }
        return answer;
    }
}
