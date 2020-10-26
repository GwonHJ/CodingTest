#include <cstdio>
#include <stack>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
vector<int> a(1001);
bool check[1001];
void dfs(int node) {
    if(check[node])	return;
    check[node]= true;
    dfs(a[node]);
}

int main() {
	int T;	scanf("%d",&T);
	for(int j = 0; j<T; j++){
		int N;
		scanf("%d",&N);
		for(int i = 1; i<=N; i++){
			a.clear();
			check[i]=0;
		}
		for(int i = 1; i<=N; i++){
			scanf("%d",&a[i]);
		}
		int count = 0;
		for (int i = 1; i<= N; i++){
			if(check[i]==false){
				dfs(i);
				count +=1;
			}
		}
		printf("%d\n",count);	
	}
	return 0;
}
