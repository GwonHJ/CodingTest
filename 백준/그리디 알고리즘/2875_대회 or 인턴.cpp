#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;

int main(){
	int W, M, C;	scanf("%d %d %d",&W, &M, &C);
	while(C!=0){
		if(W/2>=M){
			if(W/2>M&&W%2==0&&C>=2){
				W -= 2;
				C -=2;
			}else{
				W -=1;
				C -=1;
			}
		}
		else{
			M -=1;
			C -=1;
		}
	}
	int ans = min(W/2,M);
	printf("%d",ans); 
	return 0;
}
