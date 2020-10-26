#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	int T;	scanf("%d",&T);
	for(int i = 1; i<=T; i++){
		string s;
		cin >> s;
		int count = 0;
		for(int j = 0; j<s.size();j++){
			if(s[j]=='(')	count ++;
			else	count--;
			if(count<0){
				printf("NO\n");
				break;
			}
			if(j==s.size()-1){
				if(count==0)	printf("YES\n");
				else	printf("NO\n");
			}
		}
	}
	return 0;
}
