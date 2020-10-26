#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool check(vector <int> budgets, int ans, int M, int N){
    int sum = 0;
    for(int i = 0; i< N; i++){
        if(budgets[i] <= ans)   sum += budgets[i];
        else    sum += ans;
    }
    return sum <= M;
}
int solution(vector<int> budgets, int M) {
    int answer = 0;
    int N = budgets.size();
    sort(budgets.begin(),budgets.end());
    int l = 1;
    int r = budgets[N-1];
    
    while(l<=r){
        int mid = (l+r)/2;
        if(check(budgets, mid,M, N)){
            if(answer <= mid)    answer = mid;
            l = mid +1;
        }
        else{
            r = mid -1;
        }
    }
    return answer;
}
