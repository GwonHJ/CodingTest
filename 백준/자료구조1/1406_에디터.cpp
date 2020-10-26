#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<stack>
using namespace std;

int main() {
	string s;
	int N;
	cin >> s >> N;
	stack <char> stk;
	for(int i=0;i<s.size();i++){
		stk.push(s[i]);
	}
	stack <char> stk2;
	int cursor = stk.size();
	string c;
	for(int i=0; i<=N;i++){
		getline(cin,c);
		if(c[0]=='L'){
			if(stk.size()==0)	continue;
			stk2.push(stk.top());
			stk.pop();
		}
		else if(c[0]=='D'){
			if(stk2.size()==0)	continue;
			stk.push(stk2.top());
			stk2.pop();
		}
		else if(c[0]=='B'){
			if(stk.size()==0)	continue;
			stk.pop();
		}
		else if(c[0]=='P'){
			stk.push(c[2]);
		}
	}
	while(stk.size()!=0){
		stk2.push(stk.top());
		stk.pop();
	}
	while(stk2.size()!=0){
		cout << stk2.top();
		stk2.pop();
	}
	return 0;
}
