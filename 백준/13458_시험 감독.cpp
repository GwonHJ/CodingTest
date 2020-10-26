#include <string>
#include <algorithm>

using namespace std;

int arr[1000000];

int main(){
	int N;	scanf("%d",&N);
	for(int i = 0; i<N; i++){
		scanf("%d",&arr[i]);
	}
	int main, sub;	scanf("%d %d",&main, &sub);
	long long ans = 0;
	for(int i = 0; i<N; i++){
		arr[i] -= main;
		ans++;
		if(arr[i]>0){//arr[i]-main이 음수가 되는 경우
			ans += arr[i]/sub;
			if(arr[i]%sub!=0)	ans++;	
		}
	}
	printf("%lld",ans);
  
}
