#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    long long num_2 = 1;
    long long num_1 = 1;
    long long num = 1;
    for(long long i = 2; i<=n ; i++){
        num = num_1 % 1234567 + num_2 % 1234567;
        num_1 = num_2;
        num_2 = num;
        }
    answer = num % 1234567;
    
    return answer;
}

