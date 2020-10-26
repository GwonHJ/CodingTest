#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;

int main() {
	string s;
	cin >> s;
	int ans = 0; string num = ""; char sign = '+';
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '-') {
			if (sign == '-') {
				ans -= stoi(num);
				num = "";
			}
			else {
				ans += stoi(num);
				num = "";
			}
			sign = '-';
		}
		else if (s[i] == '+') {
			if (sign == '-') {
				ans -= stoi(num);
				num = "";
			}
			else {
				ans += stoi(num);
				num = "";
			}
			//sign = '+';
		}
		else {
			num += s[i];
		}
		if (i == s.size() - 1) {
			if (sign == '-') {
				ans -= stoi(num);
			}
			else {
				ans += stoi(num);
			}
		}
	}
	printf("%d", ans);
	return 0;
}
