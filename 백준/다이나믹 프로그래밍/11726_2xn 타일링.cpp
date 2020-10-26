#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int N;	scanf("%d", &N);
	int A[N];
	A[0] = 1;
	A[1] = 2;
	for (int i = 2; i < N; i++) {
        if(A[i-2]>10007||A[i-1]>10007)    A[i] = A[i - 1]%10007 + A[i - 2]%10007;
        else    A[i] = A[i - 1] + A[i - 2];
	}
	printf("%d", A[N - 1]%10007);
	return 0;
}
