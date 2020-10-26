#include <cstdio>
#include <stack>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
vector<int> a[20001];
int color[20001];
bool dfs(int node, int c) {
    color[node] = c;
    for (int i =0; i<a[node].size(); i++){
    	int next = a[node][i];
    	if(color[next]==0){
    		if(dfs(next,3-c)==false)	return false;
			}
    	else if(color[next]==color[node])	return false;
	}
	return true;
}


int main() {
	int T;
	scanf("%d",&T);
	for(int k=0; k<T; k++){
		int N, M;
		scanf("%d %d",&N, &M);
		for(int i=1; i<= N; i++){
			a[i].clear();
			color[i] = 0;
		}
		for(int i = 0; i<M; i++){
			int u,v;
			scanf("%d %d",&u,&v);
			a[u].push_back(v);
			a[v].push_back(u);
		}
		
		bool check = true;
		for(int i = 1; i <=N; i++){
			if(color[i]==0){
				if(dfs(i,1)==false)	check = false;
			}
		}
		
		printf("%s\n",check ? "YES" : "NO");
	}
	
	return 0;
}
