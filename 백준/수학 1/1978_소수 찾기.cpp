#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int T;	scanf("%d",&T);
	int ans = 0;
	for(int i = 0; i<T; i++){
		int num; scanf("%d",&num);
		int count = 0;
		if(num==1)	continue;
		for(int j = 2; j * j <= num; j++){
			if(num%j==0)	count++;
		}
		if(count == 0){
			ans ++;
		}
	}
	printf("%d",ans);
   return 0;
}
