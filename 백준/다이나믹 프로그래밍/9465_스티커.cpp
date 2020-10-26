#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int T;	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		int N; scanf("%d", &N);
		int score[2][N] = {0};
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < N; k++) {
				scanf("%d", &score[j][k]);
			}
		}
		int D[3][N] ={0};
		int answer = 0;
		D[0][0] = 0;
		D[1][0] = score[0][0];
		D[2][0] = score[1][0];
		for (int j = 1; j < N; j++) {
			D[0][j] = max(max(D[0][j - 1], D[1][j - 1]), D[2][j - 1]);
			D[1][j] = max(D[0][j - 1], D[2][j - 1]) + score[0][j];
			D[2][j] = max(D[0][j - 1], D[1][j - 1]) + score[1][j];
		}
		answer = max(max(D[0][N - 1], D[1][N - 1]), D[2][N - 1]);
		printf("%d\n", answer);
	}

	return 0;
}
