#include<cstdio>
#include<cstring>
#include<algorithm>
#include<iostream>
#include<queue>
#include<vector>
using namespace std;
struct Edge {
	int to;
	int cost;
	Edge(int to, int cost) : to(to), cost(cost){
	}
};
vector <Edge> a[100001];
bool check[100001];
int dist[100001];
void bfs(int node){
	memset(dist,0,sizeof(dist));
	memset(check,false,sizeof(check));
	queue <int> q;
	q.push(node);
	check[node] = true;
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i = 0; i< a[x].size();i++){
			Edge &e = a[x][i];
			if(check[e.to] == false){
				dist[e.to] = dist[x] + e.cost;
				q.push(e.to);
				check[e.to] = true;
			}
		}
	}
}
int main(){
	int N;	scanf("%d",&N);
	for(int i = 1; i<=N; i++){
		int node;	scanf("%d",&node);
		while(1){
			int next, depth;
			scanf("%d",&next);
			if(next==-1)	break;
			scanf("%d",&depth);
			a[node].push_back(Edge(next,depth));
		}
	}
	bfs(1);
	int max_node = 1;
	for(int i = 2; i<=N; i++){
		if(dist[i]>dist[max_node])	max_node = i;
	}
	bfs(max_node);
	int ans = dist[1];
	for(int i = 2; i<=N; i++){
		if(ans < dist[i])	ans = dist[i];
	}
	printf("%d",ans);
	

	return 0;
}
