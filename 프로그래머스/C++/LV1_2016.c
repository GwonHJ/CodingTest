#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int a, int b) {
    // 리턴할 값은 메모리를 동적 할당해주세요.
    char* answer = (char*)malloc(answer);
    int i = 1;
    int sum = 0;
    while(i<a){
        if(i%2==1&&i<8){
            sum = sum + 31;
        }
        else if(i%2==0&&i>7){
            sum = sum + 31;
        }
        else{
            if(i==2){
                sum = sum + 29;
            }
            else{
                sum = sum + 30;
        }
        } 
        i++;
    }
    sum = sum + b;
    int weekday = sum%7;
    switch (weekday){
        case 0 : answer = "THU";
    break;
        case 1 : answer = "FRI";
    break;
        case 2 : answer = "SAT";
    break;
        case 3 : answer = "SUN";
    break;
        case 4 : answer = "MON";
    break;
        case 5 : answer = "TUE";
    break;
        case 6 : answer = "WED";
    break;
    }
        
    return answer;
}

