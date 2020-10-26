#include <string>
#include <vector>

using namespace std;

bool visited[200];
vector<int> link[200];

void bfs(int here){
    visited[here] = true;
    for(int i=0; i<link[here].size(); ++i){
        int next = link[here][i];
        if(!visited[next]){
            bfs(next);
        }
    }
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    fill_n(visited,200,false);
    for(int i = 0; i<computers.size(); i++){
        for(int j = 0; j<computers[i].size(); j++){
            if(computers[i][j]==1)  link[i].push_back(j);
        }
    }
    
    for(int i = 0; i<n; ++i){
        if(!visited[i]){
            bfs(i);
            answer++;
        }
    }
    return answer;
}
