import java.util.*;

class Solution {
    static int sum = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int sign_case = numbers.length;
        String binaryString;
        
        for(int i = 0; i<Math.pow(2, sign_case); i++){
            binaryString = Integer.toBinaryString(i);
            
            Cal(binaryString, numbers);
            if(sum == target)   answer++;
            sum = 0;
        }
        
        return answer;
    }
    
    public void Cal(String binary, int[] numbers){
        if(binary.length() != numbers.length){
            for(int i = 0; i<numbers.length-binary.length(); i++){
                sum += numbers[i];
            }
            for(int i =0; i<binary.length(); i++){
                if(binary.charAt(i) == '0'){
                    sum+= numbers[i+numbers.length-binary.length()];
                }else{
                    sum-= numbers[i+numbers.length-binary.length()];
                }
            }
        }else{
            for(int i = 0; i<binary.length(); i++){
                if(binary.charAt(i) == '0'){
                    sum+= numbers[i];
                }else{
                    sum-= numbers[i];
                }
            }
        }
        return;
    }
}
