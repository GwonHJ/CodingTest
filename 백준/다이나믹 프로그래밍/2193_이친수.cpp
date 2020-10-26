#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int N; scanf("%d",&N);
	long long D[2][N];
	D[0][0] = 0;
	D[1][0] = 1;
	for(int i = 1; i<N; i++){
		D[0][i] = D[0][i-1] + D[1][i-1];
		D[1][i]	= D[0][i-1];
	}
	long long ans = D[0][N-1]+D[1][N-1];
	printf("%lld",ans);
	return 0;
}
