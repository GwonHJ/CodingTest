#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int T; scanf("%d",&T);
	for(int i = 0; i<T; i++){
		int num;	scanf("%d",&num);
		int D[num+1];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for(int i = 4; i<=num;i++){
			D[i]=D[i-1]+D[i-2]+D[i-3];
		}
		printf("%d\n",D[num]);
	}
	return 0;
}
