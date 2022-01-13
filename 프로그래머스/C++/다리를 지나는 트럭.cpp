#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue <int> bridge;
    int now_weight = 0; 
    int i = 0;  int n= truck_weights.size();
    while(i<n){
        if(weight>=now_weight+truck_weights[i]){
            now_weight += truck_weights[i];
            bridge.push(truck_weights[i]);
            i++;
        }
        else bridge.push(0);//탑승 못하면 지금 다리에 0을 추가
        if(bridge.size()>=bridge_length){
            now_weight -= bridge.front();//제일앞에 있는 무게 빼주기
            bridge.pop();
        }
        answer++;
        
    }
    answer += bridge_length;
    
    return answer;
}
