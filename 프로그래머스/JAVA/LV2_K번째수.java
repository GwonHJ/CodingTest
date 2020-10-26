import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        
        for(int i = 0; i<N; i++){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            int index = 0;
            for(int j = commands[i][0]-1; j<commands[i][1]; j++){
                arr[index] = array[j];
                index++;
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        
        }
        
        return answer;
    }
}
