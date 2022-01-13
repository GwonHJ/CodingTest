#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int arr1[5] = {1,2,3,4,5};
    int arr2[8] = {2,1,2,3,2,4,2,5};
    int arr3[10] = {3,3,1,1,2,2,4,4,5,5};
    int N = answers.size();
    int ans1 =0; int ans2 = 0; int ans3 = 0;
    for(int i =0 ; i<N; i++){
        if(arr1[i%5] == answers[i])  ans1++;
        if(arr2[i%8] == answers[i])  ans2++;
        if(arr3[i%10] == answers[i])  ans3++;
    }
    if(ans1 == ans2 && ans2 == ans3)    {
        answer.push_back(1);
        answer.push_back(2);
        answer.push_back(3);
    }else if(ans1 == ans2 && ans2 > ans3){
        answer.push_back(1);
        answer.push_back(2);
    }else if(ans1 == ans3 && ans3 > ans2){
        answer.push_back(1);
        answer.push_back(3);
    }else if(ans3 == ans2 && ans2 > ans1){
        answer.push_back(2);
        answer.push_back(3);
    }else if(ans1 > ans2 && ans1 > ans3){
        answer.push_back(1);
    }else if(ans2 > ans1 && ans2 > ans3){
        answer.push_back(2);
    }else{
        answer.push_back(3);
    }
    return answer;
}
