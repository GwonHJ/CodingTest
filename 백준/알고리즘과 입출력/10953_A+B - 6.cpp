#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	int T;	scanf("%d",&T);
	string s="";
	for(int i = 0; i<T; i++){
		cin>>s;
		int sum = 0;
		sum = (s[0]-'0')+(s[2]-'0');
		printf("%d\n",sum);
	}
	return 0;
}
