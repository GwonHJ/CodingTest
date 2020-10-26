#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
using namespace std;

int main(){
	int N;	int sum;
	scanf("%d %d",&N,&sum);
	int arr[N];
	for(int i = 0; i<N; i++){
		scanf("%d",&arr[i]);
	}
	int ans=0;
	for(int i = N-1 ; i>=0; i--){
		ans += sum / arr[i];
		sum = sum % arr[i];
	}
	printf("%d",ans);
}
