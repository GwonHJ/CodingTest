#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	string s;
	cin >> s;
	for(int i=1; i<=s.size(); i++){
		cout<<s[i-1];
		if(i%10==0)	printf("\n");
	}
	return 0;
}
