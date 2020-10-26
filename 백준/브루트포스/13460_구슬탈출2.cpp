#include <algorithm>
#include <string>
#include <iostream>
using namespace std;

int N, M;
char arr[10][10];
int r_row, r_col;
int b_row, b_col;
int Goal_row, Goal_col;
int ans;

int move(int m){
	int Finish;
	int index;
	switch(m){
		case 0://위로 이동
			Finish = 1;
			index = 0;
			for(int i = 0; i<N; i++){//R이동 
				if(arr[i][r_col]== '#')	index = i+1;
				else if(arr[i][r_col]=='R'){
					if((Goal_col == r_col)&&(Goal_row>=index)&&(Goal_row<=r_row)){
						Finish = 2;
						arr[i][r_col] = '.';
						break;
					}
					arr[i][r_col] = '.';
					arr[index][r_col] = 'R';
					r_row = index;
					break;
				}
				else if(arr[i][r_col]=='B'){//R과 B가 같은 컬럼에 있고, B가 R보다 위에 있다면 이동을 시켜줘야함 
					if((Goal_col == r_col)&&(Goal_row>=index)&&(Goal_row<=b_row))	return 3;
					arr[i][r_col] = '.';
					arr[index][r_col] = 'B';
					b_row = index;
					index++;
				}
			}
			index = 0;
			for(int i = 0; i<N; i++){//B이동 
				if(arr[i][b_col]== '#')	index = i+1;
				else if(arr[i][b_col]=='R') index++;//만약 R과 B가 같은 컬럼이고 B가 이동할때, R을 만난다면 이미 위에서 이동했기 때문에 인덱스만 바꿔주면 된다. 
				else if(arr[i][b_col]=='B'){
					if((Goal_col == b_col)&&(Goal_row>=index)&&(Goal_row<=b_row))	return 3;
					arr[i][b_col] = '.';
					arr[index][b_col] = 'B';
					b_row = index;
					break;
				}
			}
			break;
		case 1://아래로 이동 
			Finish = 1;
			index = N-1;
			for(int i = N-1; i>=0; i--){//R이동 
				if(arr[i][r_col]== '#')	index = i-1;
				else if(arr[i][r_col]=='R'){
					if((Goal_col == r_col)&&(Goal_row<=index)&&(Goal_row>=r_row)){
						Finish = 2;
						arr[i][r_col] = '.';
						break;	
					}
					arr[i][r_col] = '.';
					arr[index][r_col] = 'R';
					r_row = index;
					break;
				}
				else if(arr[i][r_col]=='B'){//R이랑 B랑 같은 컬럼에 B가 R보다 밑에 있을 
					if((Goal_col == r_col)&&(Goal_row<=index)&&(Goal_row>=b_row))	return 3;
					arr[i][r_col] = '.';
					arr[index][r_col] = 'B';
					b_row = index;
					index--;
				}
			}
			index = N-1;
			for(int i = N-1; i>=0; i--){//B이동 
				if(arr[i][b_col]== '#')	index = i-1;
				else if(arr[i][b_col]=='R') index--;//만약 R과 B가 같은 컬럼이고 B가 이동할때, R을 만난다면 이미 위에서 이동했기 때문에 인덱스만 바꿔주면 된다. 
				else if(arr[i][b_col]=='B'){
					if((Goal_col == b_col)&&(Goal_row<=index)&&(Goal_row>=b_row))	return 3;
					arr[i][b_col] = '.';
					arr[index][b_col] = 'B';
					b_row = index;
					break;
				}
			}
			break;
			
		case 2://왼쪽으로 이동. 
			Finish = 1;
			index = 0;
			for(int i = 0; i<M; i++){//R이동 
				if(arr[r_row][i]== '#')	index = i+1;
				else if(arr[r_row][i]=='R'){
					if((Goal_row == r_row)&&(Goal_col>=index)&&(Goal_col<=r_col)){
						Finish = 2;
						arr[r_row][i] = '.';
						break;
					}	
					arr[r_row][i] = '.';
					arr[r_row][index] = 'R';
					r_col = index;
					break;
				}
				else if(arr[r_row][i]=='B'){//R과 B가 같은 로우에 있고, B가 R보다 왼쪽에 있다면 B를 이동 시켜줘야함 
					if((Goal_row == r_row)&&(Goal_col>=index)&&(Goal_col<=b_col))	return 3;
					arr[r_row][i] = '.';
					arr[r_row][index] = 'B';
					b_col = index;
					index++;
				}
			}
			index = 0;
			for(int i = 0; i<M; i++){//B이동 
				if(arr[b_row][i]== '#')	index = i+1;
				else if(arr[b_row][i]=='R') index++;//만약 R과 B가 같은 로우이고 B가 이동할때, R을 만난다면 이미 위에서 이동했기 때문에 인덱스만 바꿔주면 된다. 
				else if(arr[b_row][i]=='B'){
					if((Goal_row == b_row)&&(Goal_col>=index)&&(Goal_col<=b_col))	return 3;
					arr[b_row][i] = '.';
					arr[b_row][index] = 'B';
					b_col = index;
					break;
				}
			}
			break;
		case 3://오른쪽으로 
			Finish = 1;
			index = M-1;
			for(int i = M-1; i>=0; i--){//R이동 
				if(arr[r_row][i]== '#')	index = i-1;
				else if(arr[r_row][i]=='R'){
					if((Goal_row == r_row)&&(Goal_col<=index)&&(Goal_col>=r_col)){
						Finish = 2;
						arr[r_row][i] = '.';
						break;
					}	
					arr[r_row][i] = '.';
					arr[r_row][index] = 'R';
					r_col = index;
					break;
				}
				else if(arr[r_row][i]=='B'){//R과 B가 같은 로우에 있고, B가 R보다 왼쪽에 있다면 B를 이동 시켜줘야함 
					if((Goal_row == r_row)&&(Goal_col<=index)&&(Goal_col>=b_col))	return 3;
					arr[r_row][i] = '.';
					arr[r_row][index] = 'B';
					b_col = index;
					index--;
				}
			}
			index = M-1;
			for(int i = M-1; i>=0; i--){//B이동 
				if(arr[b_row][i]== '#')	index = i-1;
				else if(arr[b_row][i]=='R') index--;//만약 R과 B가 같은 로우이고 B가 이동할때, R을 만난다면 이미 위에서 이동했기 때문에 인덱스만 바꿔주면 된다. 
				else if(arr[b_row][i]=='B'){
					if((Goal_row == b_row)&&(Goal_col<=index)&&(Goal_col>=b_col))	return 3;
					arr[b_row][i] = '.';
					arr[b_row][index] = 'B';
					b_col = index;
					break;
				}
			}
			break;
		default :
			break;
	}
	
	return Finish;
}
void DFS(int depth){
	if(depth >= 11){
		return;
	}
	int reset[N][M];
	for(int i = 0; i<N; i++)
		for(int j = 0; j<M; j++)
			reset[i][j] = arr[i][j];
	int reset_rr = r_row; int reset_rc = r_col;
	int reset_br = b_row; int reset_bc = b_col;
	int Finish;
	for(int k = 0; k<4; k++){
		Finish = move(k);
		if(Finish == 1){
			DFS(depth+1);
			for(int i = 0; i<N; i++)
				for(int j = 0; j<M; j++)
					arr[i][j] = reset[i][j];
			r_row = reset_rr; r_col = reset_rc;
			b_row = reset_br; b_col = reset_bc;
		}else if(Finish == 2){
			ans = min(ans, depth);
			for(int i = 0; i<N; i++)
				for(int j = 0; j<M; j++)
					arr[i][j] = reset[i][j];
			r_row = reset_rr; r_col = reset_rc;
			b_row = reset_br; b_col = reset_bc;
		}
		else if(Finish == 3){
			for(int i = 0; i<N; i++)
				for(int j = 0; j<M; j++)
					arr[i][j] = reset[i][j];
			r_row = reset_rr; r_col = reset_rc;
			b_row = reset_br; b_col = reset_bc;
		}
	}
	
}
int main(){
	scanf("%d %d",&N, &M);
	for(int i =0; i<N; i++){
		for(int j = 0; j<M; j++){
			cin >> arr[i][j];
			if(arr[i][j] == 'R'){
				r_row = i;  r_col =j;
			}
			if(arr[i][j] == 'B'){
				b_row = i; b_col = j;
			}
			if(arr[i][j] == 'O'){
				Goal_row = i; Goal_col = j;
			}
		}
	}

	ans = 123456;
	DFS(1);
	if(ans == 123456)	printf("%d",-1);
	else	printf("%d",ans);
	return 0;
}
