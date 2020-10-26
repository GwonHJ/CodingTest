#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
int binary[20];

void trans_bin(int n){
    for(int i = 0; i<20; i++){
        binary[i] = n%2;
        n = n/2;
    }
}
bool trans(int bi[], vector<int> numbers, int target){
    int N = numbers.size();
    int sum = 0;
    for(int i =0; i<N; i++){
        if(bi[i]==0)    sum +=numbers[i];
        else    sum -= numbers[i];
    }
    return (target == sum);
}
int solution(vector<int> numbers, int target) {
    int answer = 0;
    int N = numbers.size();
    for(int i = 0; i<pow(2,N); i++){
        trans_bin(i);
        if(trans(binary,numbers,target))    answer++;
    }
    return answer;
}
