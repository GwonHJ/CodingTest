#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int n; scanf("%d",&n);
	int arr[n];
	for(int i =0; i<n; i++){
		scanf("%d",&arr[i]);
	}
	int D[n][2];
	D[0][0] = 0;
	D[0][1] = arr[0];
	D[1][0] = arr[0];
	D[1][1] = arr[0]+arr[1];
	for(int i = 2; i<n; i++){
		D[i][0] = max(D[i-1][1],D[i-1][0]);
		D[i][1] = max(D[i-1][0]+arr[i],D[i-2][0]+arr[i-1]+arr[i]);
	}
	printf("%d",max(D[n-1][0],D[n-1][1]));
	return 0;
}
