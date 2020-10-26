#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int N;
	string s;
	cin >> N >> s;
	int ans =0;
	for(int i=0; i<N; i++){
		ans += s[i] - '0';
	}
	printf("%d",ans);
	return 0;
}
