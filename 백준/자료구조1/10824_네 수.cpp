#include<iostream>
#include<string>
#include<algorithm>
#include<deque>
using namespace std;

int main() {
	string s1;	string s2;
	string num1; string num2; string num3; string num4;
	cin >> num1 >> num2 >> num3 >> num4;
	s1 = num1 + num2;
	s2 = num3 + num4;
	long long ans = stol(s1) + stol(s2);
	printf("%lld",ans);
	return 0;
}
