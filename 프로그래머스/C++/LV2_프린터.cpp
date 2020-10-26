#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    vector<int> arr;
    int n = priorities.size();
    for(int i = 0; i<n; i++)    arr.push_back(priorities[i]);
    sort(arr.begin(), arr.end());
    int i = 0; int count = 1;
    while(1){
        if(arr.back() == priorities[i]){
            if(i == location){
                answer = count;
                break;
            }
            arr.pop_back();
            count++;
        }
        i++;
        if(i==n)    i=0;
    }
    return answer;
}
