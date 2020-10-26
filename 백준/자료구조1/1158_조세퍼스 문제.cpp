#include<iostream>
#include<string>
#include<algorithm>
#include<queue>
using namespace std;

int main() {
	queue <int> que;
	int size;	int out;
	scanf("%d %d",&size,&out);
	for(int i=1;i<=size;i++){
		que.push(i);
	}
	printf("<");
	int j =1;
	while(que.size()!=0){
		if(j%out==0){
			if(que.size()==1){
				printf("%d>",que.front());
				break;
			}
			printf("%d, ",que.front());
			que.pop();
		}
		else{
			if(que.size()==1){
				printf("%d>",que.front());
				break;
			}
			que.push(que.front());
			que.pop();
		}
		j++;
	}
	return 0;
}
