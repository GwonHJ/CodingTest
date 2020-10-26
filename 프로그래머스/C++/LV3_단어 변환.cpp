#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[50];
int Distance[50];

bool link(string begin, string next, int N){
    int count = 0;
    for(int i = 0; i<N; i++){
        if(begin[i] != next[i])    count++;
        if(count>1) return false;
    }
    return true;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    fill_n(Distance,50,-1);
    
    int N = begin.size();
    int M = words.size();
    
    for(int i = 0; i<M; i++){
        for(int j = 0; j<M; j++){
            if(j==i)    continue;
            if(link(words[i],words[j],N))    graph[i].push_back(j);
        }
    }//graph만들기
    int start = 0;
    for(int i = 0; i<M; i++){
        if(target==words[i]){
            start = i;
            break;
        }
        if(i== M-1 && target != words[i])
            return 0;
    }//target을 시작점으로 만들기
    //bfs시작
    queue <int> q;
    Distance[start] = 0;
    q.push(start);
    while(!q.empty()){
        int here = q.front();
        q.pop();
        if(link(words[here],begin,N)){
            answer = Distance[here]+1;
            return answer;
        }   
        for(int i = 0; i<graph[here].size(); i++){
            int next = graph[here][i];
            if(Distance[next]==-1){
                q.push(next);
                Distance[next] = Distance[here]+1;
            }
        }
    }
    answer = 0;
    return answer;
}
