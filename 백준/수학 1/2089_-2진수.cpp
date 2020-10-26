#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int N; scanf("%d",&N);
	string s = "";
	char mod='0';
	if(N==0){
		cout<<0<<"\n";
		return 0;
	}	while(N!=0){
		if(N%2==0){	
			mod = '0';
			s += mod;
			N = N/-2;
		}
		else{
			mod = '1';
			s += mod;
			N = (N-1)/-2;
		}
	}
		
	reverse(s.begin(),s.end());
	cout << s << "\n";
   return 0;
}
