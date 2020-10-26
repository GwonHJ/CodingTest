#include <cstdio>
#include <iostream>
#include <stack>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int check[1000000];
int pow(int x, int p){
	int ans = 1;
	for(int i =0; i<p; i++)	ans = ans*x;
	return ans;
}
int next(int a, int p){
	int ans = 0;
	while(a>0){
		ans += pow(a%10,p);
		a/=10;
	}
	return ans;
}
int length(int a, int p, int cnt){
		if(check[a]!=0)	return	check[a]-1;
		check[a] = cnt;
		int b = next(a,p);
		return length(b,p,cnt+1);
}
int main() {
	int a, p;
	cin >> a >> p;
	cout << length(a, p, 1) << "\n";
	return 0;
}
