#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    
    for(int i = 0; i<prices.size()-1; i++){
        answer.push_back(0);
        for(int j = i+1; j<prices.size(); j++){
            if(prices[i]>prices[j]){
                answer[i] = j-i;
                break;
            }
        }
    }
    
    for(int i = 0; i<prices.size(); i++){
        if(answer[i] == 0)
            answer[i] = prices.size()-i-1;
    }
    answer.push_back(0);
    return answer;
}
