#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;

bool visited[7];
int arr[7];
set<int> s;

bool sosu(int num){
    if(num == 0 || num == 1){
        return false;
    }
    if(num == 2){
        return true;
    }
    
    for(int i = 2; i*i<=num; i++){
        if(num % i == 0)
            return false;
    }
    
    return true;
}


void permu(int finish, int step, string numbers){
    if(step == finish){
        
        int num = 0;
        
        for(int i = 0; i<step; i++){
            num = num*10 + arr[i];
        }
        if(sosu(num))
            s.insert(num);
        
        return;
    }
    
    for(int i = 0; i<numbers.size(); i++){
        if(visited[i])
            continue;
        visited[i] = true;
        arr[step] = numbers[i]-'0';
        permu(finish, step+1, numbers);
        visited[i] = false;
        arr[step] = 0;
    }
}

int solution(string numbers) {
    int answer = 0;
    
    for(int i = 1; i<=numbers.size(); i++){
        fill_n(visited, 7, false);
        fill_n(arr, 7, 0);
        permu(i, 0, numbers);
    }
    
    answer = s.size();
    return answer;
}
