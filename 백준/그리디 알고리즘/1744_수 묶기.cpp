#include<cstdio>
#include<string>
#include<algorithm>
#include<iostream>
#include<vector>
using namespace std;

int main(){
	int N;	scanf("%d",&N);
	int arr[N];
	for(int i=0;i<N;i++){
		scanf("%d",&arr[i]);
	}
	sort(arr,arr+N);
	int ans =0;
	for(int i=0; i<N; i+=2){
		if(arr[i]>=0)	break;
		else if(arr[i+1]>0)	ans += arr[i];
		else{
			if(i==N-1){
				ans += arr[i];
				break;
			}
			ans += arr[i]*arr[i+1];

		}		}
	for(int i = N-1; i>=0;i-=2){
		if(arr[i]<=0)	break;
		else if(arr[i]==1||arr[i-1]==1){
			ans += arr[i];
			i +=1;
			continue;
		}
		else if(arr[i]>0&&arr[i-1]<=0)	ans += arr[i];
		else	ans += arr[i]*arr[i-1];
	}
	printf("%d",ans);
	return 0;
}
