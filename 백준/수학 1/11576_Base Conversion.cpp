#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int a,b,N; scanf("%d %d %d",&a,&b,&N);
	int A[N]; int num=0;
	string ans ="";
	for(int i=N-1; i>=0; i--){
		scanf("%d",&A[i]);
	}
	for(int i=N-1; i>=0; i--){
		num = num*a + A[i]; 
	}
	while(num!=0){
		int mod=num%b;
		ans += (char)mod + '0';
		num = num/b;
		if(num==0)	break;
		ans += " ";
	}
	reverse(ans.begin(),ans.end());
	for(int i = 0; i<ans.size();i++){
		
		if(ans[i]!=' '){	
		int answer = ans[i] - '0';
		printf("%d",answer);	
	}
	else {
		printf(" ");
	}
	}
   return 0;
}
