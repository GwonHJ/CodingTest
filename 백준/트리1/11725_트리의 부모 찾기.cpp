#include<stdio.h>
#include<string>
#include<algorithm>
#include<iostream>
#include<queue>
#include<vector>
using namespace std;
vector <int> a[100001];
int depth[100001];
int parent[100001];
int check[100001];
int main(){
	int N;	scanf("%d",&N);
	for(int i = 1; i<N; i++){
		int n1, n2;
		cin >> n1 >> n2;
		a[n1].push_back(n2);
		a[n2].push_back(n1);
	}
	queue <int> q;
	q.push(1);
	while(!q.empty()){
		int x = q.front();
		q.pop();
		for(int i = 0; i<a[x].size();i++){
			int next = a[x][i];
			if(check[next]==false){
				check[next]=true;
				parent[next] = x;
				q.push(next);
			}
		}
	}
	for(int i =2; i<=N;i++){
		printf("%d\n", parent[i]);
	}

	return 0;
}
