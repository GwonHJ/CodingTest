#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	int T;	scanf("%d",&T);
	for(int i = 1; i<=T; i++){
		int a, b;
		scanf("%d %d",&a,&b);
		int sum = a+b;
		printf("Case #%d: %d + %d = %d\n",i,a,b,sum);
	}
	return 0;
}
