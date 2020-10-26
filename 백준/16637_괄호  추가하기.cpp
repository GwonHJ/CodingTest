#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

int num[10];
char oper[9];
int D[10];
int min_D[10];

int calculate(int a, int b, char c){
	if(c == '+')	return a + b;	
	else if(c == '-')	return a - b;
	else	return a * b;
}
int main(){
	int N; scanf("%d",&N);
	
	for(int i = 0; i<N/2; i++){
		scanf("%d%c",&num[i],&oper[i]);
	}
	scanf("%d",&num[N/2]);
	
	D[0] = num[0];
	D[1] = calculate(D[0],num[1],oper[0]);
	min_D[0] = num[0];
	min_D[1] = calculate(D[0],num[1],oper[0]);
	
	
	for(int i = 2; i<=N/2; i++){
		int a = calculate(D[i-2],calculate(num[i-1],num[i],oper[i-1]),oper[i-2]);    
		int b = calculate(D[i-1],num[i],oper[i-1]);
		
		int c = calculate(min_D[i-2],calculate(num[i-1],num[i],oper[i-1]),oper[i-2]);    
		int d = calculate(min_D[i-1],num[i],oper[i-1]);
		
		min_D[i] = min(min(a,b),min(c,d));
		D[i] = max(max(a,b),max(c,d));
		
	}
	printf("%d",D[N/2]);
	return 0;
}
