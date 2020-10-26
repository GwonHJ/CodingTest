#include <string>
#include <vector>
#include <queue>
using namespace std;
int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    priority_queue<int> pq;
    int i=0;
    while(stock<k){        
        while(i<dates.size()&&stock>=dates[i]){
            pq.push(supplies[i]);
            i++;            
        }
        stock+=pq.top();
        pq.pop();
        answer++;        
    }
    return answer;
}
