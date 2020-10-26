#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;

int main(){
	int N;	scanf("%d",&N);
	int arr[N];
	for(int i = 0; i< N; i++){
		scanf("%d",&arr[i]);
	}
	sort(arr,arr+N);
	int sum = 0;
	for(int i = 0; i<N; i++){
		sum += (N-i)*arr[i];
	}
	printf("%d",sum);
	return 0;
}
