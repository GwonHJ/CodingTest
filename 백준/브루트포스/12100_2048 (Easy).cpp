#include <string>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int arr[20][20];
int N;	
int ans;

void move(int m){//0 : 위, 1: 아래, 2: 왼, 3:오
	queue <int> q;
	switch(m){
		case 0 :
			for(int i = 0; i<N; i++){//i = column
				for(int j = 0; j<N; j++){// j = row
					if(arr[j][i] != 0){
						q.push(arr[j][i]);
						arr[j][i] = 0;
					}
				}
				int index = 0;
				while(!q.empty()){
					int front = q.front();
					q.pop();
					if(arr[index][i] == 0){
						arr[index][i] = front;	
					}
					else if(front == arr[index][i]){
						arr[index][i] *= 2;
						index++;
					}
					else{
						index++;
						arr[index][i] = front;
					}
				}
			}
			break;
		
		case 1 :
			for(int i = 0; i<N; i++){//i = column
				for(int j = N-1; j>=0; j--){// j = row
					if(arr[j][i] != 0){
						q.push(arr[j][i]);
						arr[j][i] = 0;
					}
				}
				int index = N-1;
				while(!q.empty()){
					int front = q.front();
					q.pop();
					if(arr[index][i] == 0){
						arr[index][i] = front;	
					}
					else if(front == arr[index][i]){
						arr[index][i] *= 2;
						index--;
					}
					else{
						index--;
						arr[index][i] = front;
					}
				}
			}
			break;
			
		case 2:
			
			for(int i = 0; i<N; i++){//i = row
				for(int j = 0; j<N; j++){// j = column
					if(arr[i][j] != 0){
						q.push(arr[i][j]);
						arr[i][j] = 0;
					}
				}
				int index = 0;
				while(!q.empty()){
					int front = q.front();
					q.pop();
					if(arr[i][index] == 0){
						arr[i][index] = front;	
					}
					else if(front == arr[i][index]){
						arr[i][index] *= 2;
						index++;
					}
					else{
						index++;
						arr[i][index] = front;
					}
				}
			}
			break;
			
		case 3:
			for(int i = 0; i<N; i++){//i = row
				for(int j = N-1; j>=0; j--){// j = column
					if(arr[i][j] != 0){
						q.push(arr[i][j]);
						arr[i][j] = 0;
					}
				}
				int index = N-1;
				while(!q.empty()){
					int front = q.front();
					q.pop();
					if(arr[i][index] == 0){
						arr[i][index] = front;	
					}
					else if(front == arr[i][index]){
						arr[i][index] *= 2;
						index--;
					}
					else{
						index--;
						arr[i][index] = front;
					}
				}
			}
			break;
			
		default:
			break;
	}
}

int Find_max(){
	int Max = 0;
	for(int i = 0; i<N; i++){
		for(int j = 0; j<N; j++){
			Max = max(Max, arr[i][j]);
		}
	}
	return Max;
}
void DFS(int depth){
	
	
	if(depth >= 5){
		ans = max(ans,Find_max());
		return;
	}	
	
	int reset[N][N];//한번이동을 하면 원래대로 돌아와야하니까 (ex:위로 이동후 아래로 이동할떄는 위로 이동하기 전의 배열로 이동)
	for(int i = 0; i<N; i++)
		for(int j = 0; j<N; j++)
			reset[i][j] = arr[i][j]; 
	 
	for(int k = 0; k<4; k++){//이동이 4가지니까
		move(k);
	
		//depth++;//★★★★★★★★★★★★★★★★이거 주의!!!!!!!★★★★★★★★★★★★★★★★★★★★★★ 
		DFS(depth+1);
		for(int i=0; i<N; i++ ){
			for(int j = 0; j<N; j++){
				arr[i][j] = reset[i][j];
			}
		}
		
	}
}
int main(){
	scanf("%d",&N);
	for(int i = 0; i<N; i++){
		for(int j=0; j<N; j++){
			scanf("%d", &arr[i][j]);
		}
	}
	ans = -123;
	
	DFS(0);
	printf("%d",ans);
}
