#include <string>
#include <queue>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue <int> q;
    int count = 0;
    for(int i = 0; i<progresses.size(); i++){
        int n = (100-progresses[i])/speeds[i];
        int mod = (100-progresses[i])%speeds[i];
        if(mod != 0)    n++;
        q.push(n);
    }
    int now = q.front();
    while(!q.empty()){
        if(now >= q.front()){
            count++;
        }
        else{
            answer.push_back(count);
            count = 1;
            now = q.front();
        }
        q.pop();
    }
    answer.push_back(count);
    return answer;
}
