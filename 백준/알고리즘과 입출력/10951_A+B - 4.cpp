#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int a; 
	int b;
	
	while(scanf("%d %d",&a,&b)!=EOF){ //입력이 없으면 와일문 탈출
		printf("%d\n",a+b);
	}
	return 0;
}
