#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	string s;
	while(1){
		getline(cin, s);
		if (s == "") break;
		cout << s<<"\n";
	}
	return 0;
}
