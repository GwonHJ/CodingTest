#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int a,b;	scanf("%d %d",&a,&b);
	int ans = 0;
	for(int i = a; i<=b; i++){
		if(i==1)	continue;
		int count = 0;
		for(int j = 2; j * j <= i; j++){
			if(i%j==0){
				count++;
				break;	
			}
		}
		if(count==0)	printf("%d\n",i);
	}
   return 0;
}
