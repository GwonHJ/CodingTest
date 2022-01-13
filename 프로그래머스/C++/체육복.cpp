#include <string>
#include <vector>
#include <iostream>
using namespace std;
int student[31];
int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    int num = lost.size();
    for(int i = 0; i<num; i++){
        student[lost[i]]--;
    }
    for(int i = 0; i<reserve.size(); i++){
        student[reserve[i]]++;
    }
    
      for(int i = n; i>1; i--){
        if(student[i]>0&&student[i-1]<0){
            student[i]--;
            student[i-1]++;
        }
    } 
    
    for(int i = 1; i<n; i++){
        if(student[i]>0 && student[i+1]<0){
            student[i]--;
            student[i+1]++;
        }
    }
    
 
    for(int i = 1; i<=n; i++){
        if(student[i]>=0)   answer++;
    }
    
    
    return answer;
}
