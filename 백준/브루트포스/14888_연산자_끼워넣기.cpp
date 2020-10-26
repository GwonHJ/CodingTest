#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int num[11];
int oper_all[10];

int cal(int index, int a, int b){
	switch(index){
		case 0:
			return a+b;
			break;
		case 1:
			return a-b;
			break;
		case 2:
			return a*b;
			break;
		case 3:
			return a/b;
			break;
		default :
			return -1234567890;
	}
}
int main(){
	int N;	scanf("%d",&N);
	int oper[4];//0 : +,1 : -,2 : x,3 : /
	for(int i = 0; i<N; i++){
		scanf("%d",&num[i]);
	}
	
	for(int i = 0; i<4; i++){
		scanf("%d",&oper[i]);
	}
	
	int index = 0;
	for(int i = 0; i<4; i++){
		for(int j = 0; j<oper[i]; j++){
			oper_all[index++] = i;
		}
	}
	
	int Max = -1234567890;
	int Min = 1234567890;
	int sum = num[0];
	
	do{
		for(int i = 0 ; i<N-1; i++){
			sum = cal(oper_all[i], sum, num[i+1]);
		}
		Max = max(Max, sum);
		Min = min(Min, sum);
		sum = num[0];
		
	}while(next_permutation(oper_all, oper_all+N-1));
	
	
	printf("%d\n%d",Max, Min);
}
