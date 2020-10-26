#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	string a;
	cin >> a;
	int answer=0;
	if (a.size() % 3 == 1) {
		a = "00" + a;
	}
	else if (a.size() % 3 == 2) {
		a = "0" + a;
	}
	for (int i = 0; i < a.size(); i++) {
		if (i % 3 == 2) {
			answer = answer * 2 + (int)a[i]-'0';
			cout << answer;
			answer = 0;
		}
		else
		{
			answer = answer * 2 + (int)a[i]-'0';
		}
	}
	return 0;
}
