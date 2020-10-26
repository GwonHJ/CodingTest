#include <string>
#include <algorithm>

using namespace std;

int V[101]; 
int W[101];
int D[101][10001];
int main(){
	int n, maxw;	scanf("%d %d",&n, &maxw);
	int ret = 0;
	for(int i = 0; i<n; i++)
		scanf("%d %d", &W[i], &V[i]);
			

	for(int i=0;i<n;i++){
		for(int j=0;j<maxw;j++){
			if(j+W[i]<= maxw){
				D[i+1][j+W[i]] = max(D[i+1][j+W[i]],D[i][j]+V[i]);
				ret = max(D[i+1][j+W[i]],ret);	
			} 
		}
	}
	
	printf("%d",ret);
}
