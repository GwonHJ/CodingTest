#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;

int main(){
	int N;	scanf("%d",&N);
	vector<pair<int, int> > v(N);
	for(int i=0; i<N; i++){
		scanf("%d %d",&v[i].second,&v[i].first);
	}
	sort(v.begin(),v.end());
	int count = 1;	int now = 0;
	for(int i = 1 ; i<N; i++){
		if(v[now].first<=v[i].second){
			count++;	now = i;
		}
	}
	printf("%d",count);
}
