#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	string stack;
	cin >> stack;
	int stick[100000]={0};	int s_head=0;	int s_tail=0;
	for(int i = 0; i<stack.size();i++){
		if(stack[i]==')'){
			if(s_tail-s_head==0)	continue;//쇠막대기가 없는데 레이저가 들어온경우우 
			if(stack[i-1]=='('){//laser가 들어왔을떄
				stick[s_tail-1]--;
				s_tail--;//마지막에 열었던 괄호는 레이저라서
				for(int j=s_head; j<s_tail;j++){
					stick[j]++;
				}
			}
			else{//stick하나가 끝일때
				s_head++; 
			}
		}
		else{//여는거 들어올때 
			stick[s_tail]=1; //여기서 이상해짐
			s_tail++; 
		}
	}
	int sum =0;
	for(int i = 0; i<s_tail;i++){
		sum += stick[i];
	}
	printf("%d",sum);
	return 0;
}
