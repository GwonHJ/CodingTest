#include<iostream>
#include<string>
#include<algorithm>
#include<deque>
using namespace std;

int main() {
	string s;
	cin >> s;
	int arr[26]={0};
	for(int i=0;i<s.size();i++){
		arr[s[i]-'a']++;
	}
	for(int i=0;i<26;i++){
		printf("%d ",arr[i]);
	}
	return 0;
}
