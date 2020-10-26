#include<iostream>
#include<string>
#include<algorithm>
#include<deque>
using namespace std;

int main() {
	string s;
	cin >> s;
	int arr[26]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	for(int i=0;i<s.size();i++){
		if(	arr[s[i]-'a']==-1)
			arr[s[i]-'a']=i;
	}
	for(int i=0;i<26;i++){
		printf("%d ",arr[i]);
	}
	return 0;
}
