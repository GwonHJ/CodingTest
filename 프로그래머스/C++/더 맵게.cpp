#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue <int, vector<int>, greater<int>> pq;
    for(int i = 0; i<scoville.size(); i++){
        pq.push(scoville[i]);
    }
    while(pq.top()<K){
        int n = pq.top();
        pq.pop();
        int m = n + pq.top()*2;
        pq.pop();
        pq.push(m);
        if(pq.size()<=1&&pq.top()<K){
            answer = -1;
            break;
        }
        answer++;
    }
    
    return answer;
}
