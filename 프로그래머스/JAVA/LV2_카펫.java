class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int y_w = 1;    int y_h = 1;
        int b_w = 1;    int b_h = 1;
        if(yellow == 1){
            b_w = 3;
            b_h = 3;
        }
        else{
        for(int i = 1; i*i<=yellow; i++){
            y_h = i;
            if(yellow%y_h != 0) continue;
            y_w = yellow/y_h;
            b_w = y_w+2;
            b_h = y_h+2;
            if(2*(b_w + b_h)-4 == brown)    break;
        }    
        }
        
        answer[0] = b_w;    answer[1] = b_h;
        return answer;
    }
}
