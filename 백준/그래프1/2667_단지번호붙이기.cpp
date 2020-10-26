#include<stdio.h>
#include<algorithm>
#include<queue>
#include<iostream>
#include<string>
using namespace std;
int A[25][25];//정점 
int d[25][25];//방문했는지 안했는지
int dx[4] = {0,0,1,-1};//차례대로 밑에 위에 오른쪽 왼쪽 방문하는거 
int dy[4] = {1,-1,0,0};
int N;
void bfs(int x, int y, int cnt){
	queue<pair<int, int> >q;
	q.push(make_pair(x,y));
	d[x][y] = cnt;
	while(!q.empty()){
		x = q.front().first; y= q.front().second;
		q.pop();
		for(int k = 0; k<4 ; k++){
			int nx = x +dx[k];//현재 좌표에서 사방으로 이동하기 위해서 더해준다
			int ny = y +dy[k];
			if(nx>=0 && nx<N && ny>= 0 && ny <N){//좌표가 범위에서 벗어나면 안되니까 
				if(A[nx][ny]==1&& d[nx][ny]==0){
					q.push(make_pair(nx,ny));
					d[nx][ny] = cnt;
				}
			} 
		}
	}
		 
}
int main(){
	scanf("%d",&N);
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			scanf("%1d",&A[i][j]);
		}
	}
	int cnt=0;
	for(int i = 0; i<N; i++){
		for(int j=0; j<N; j++){
			if(A[i][j] == 1 && d[i][j]== 0) { //정점이 1이고 방문한적이 없으면 여기부터 bfs시작 
				bfs(i, j, ++cnt);
			}
		}
	}
	printf("%d\n",cnt);
	int ans[cnt+1] = {0};
	for(int i = 0; i<N; i++){
		for (int j = 0; j< N; j++){
			ans[d[i][j]] +=1;
		}
	}
	sort(ans+1, ans + cnt+1);
	for(int i = 1; i<=cnt; i++){
		printf("%d\n",ans[i]);
	}
	return 0;
}
