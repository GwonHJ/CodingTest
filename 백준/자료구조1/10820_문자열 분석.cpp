#include<iostream>
#include<string>
#include<algorithm>
#include<deque>
using namespace std;

int main() {
	string s;
	for(int i = 0; i<100; i++){
		getline(cin,s);
		int small=0; int big = 0; int num = 0; int space = 0;
		for(int i = 0; i<s.size();i++){
			if(s[i]>='a'&&s[i]<='z')	small++;
			else if(s[i]>='A'&&s[i]<='Z')	big++;
			else if(s[i]>='0'&&s[i]<='9')	num++;
			else if(s[i]==' ')	space++;
		}
		if(small==0&&big==0&&num==0&&space==0)	break;
		printf("%d %d %d %d\n",small,big,num,space);
	}
	return 0;
}
