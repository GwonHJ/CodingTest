#include <cstdio>
#include <stack>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
vector<int> a[1001];
bool check[1001];
void dfs(int node) {
    check[node] = true;
    for ( int i =0; i<a[node].size(); i++){
    	int next = a[node][i];
    	if(check[next]==false){
    		dfs(next);
		}
	}
}

int main() {
	int N, M;
	scanf("%d %d",&N, &M);
	for(int i = 0; i<M; i++){
		int u,v;
		scanf("%d %d",&u,&v);
		a[u].push_back(v);
		a[v].push_back(u);
	}
	int count = 0;
	for (int i = 1; i<= N; i++){
		if(check[i]==false){
			dfs(i);
			count +=1;
		}
	}
	printf("%d\n",count);
	return 0;
}
