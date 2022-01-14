import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] arr1 = {1,2,3,4,5};//size = 5
        int[] arr2 = {2,1,2,3,2,4,2,5};//size = 8
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};//size =10
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i= 0; i<answers.length; i++){
            if(answers[i] == arr1[i%5]) score1++;
            if(answers[i] == arr2[i%8]) score2++;
            if(answers[i] == arr3[i%10]) score3++;
        }
        int ans_size;
        int[] ans = {1,2,3};
        if(score1 == score2 && score2 == score3)    ans_size = 3;
        else if(score1 == score2&&score2>score3){
            ans_size = 2;
            //ans[0] = 1; ans[1] = 2;
        }
        else if(score1 == score3 && score1>score2){
            ans_size = 2;
            ans[0] = 1; ans[1] = 3;
        }
        else if(score2 == score3 && score2>score1){
            ans_size = 2;
            ans[0] = 2; ans[1] = 3;
        }
        else{
            ans_size = 1;
            //if(score1>score2&&score1>score3)    ans[0] = 1;
            if(score2>score3&&score2>score1)    ans[0] = 2;
            if(score3>score2&&score3>score1)    ans[0] = 3;
        }
        
        int[] answer = new int[ans_size];
        for(int i = 0; i<ans_size; i++){
            answer[i] = ans[i];
        }
        return answer;
    }
}
