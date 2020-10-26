#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    long long num0 = 0;
    long long num1 = 1;
    long long num;
    for(long long i = 2; i<=n ; i++){
        num = num0 % 1234567 + num1 % 1234567;
        num0 = num1;
        num1 = num;
        }
    if(n>=2){
        answer = num % 1234567;
    }
    
    return answer;
}

