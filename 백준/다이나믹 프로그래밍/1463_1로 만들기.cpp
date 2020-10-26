#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int N;	scanf("%d", &N);
	int D[N];
	D[1] = 0;
    if(N>=2)    D[2] = 1;
	if(N>=3)    D[3] = 1;
	for (int i = 4; i <= N; i++) {
		if (i % 6 == 0)	D[i] = min(min(D[i / 2], D[i / 3]), D[i - 1]) + 1;
		else if (i % 2 == 0)    D[i] = min(D[i - 1], D[i / 2]) + 1;
		else if (i % 3 == 0)    D[i] = min(D[i - 1], D[i / 3]) + 1;
		else	D[i] = D[i - 1] + 1;
	}
	printf("%d", D[N]);
	return 0;
}
