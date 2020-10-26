#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int arr[100][100];//0:빈칸 1:사과 2:뱀 

static int dir_r[4] = {0,1,0,-1};//D이면 +1씩, L이면 -1씩
static int dir_c[4] = {1,0,-1,0};

int main(){
	int N;	scanf("%d",&N);
	int K;	scanf("%d",&K);
	
	for(int i = 0; i<K; i++){
		int x, y;	scanf("%d %d",&x,&y);
		arr[x-1][y-1] = 1; 
	}
	queue <pair <int, char> > turn; //바꿀 타이밍을 queue에 넣어주고 처리하면 pop해서 자동으로 다음꺼가 앞에 오도록
	int L;	scanf("%d",&L);
	
	for(int i = 0; i<L ; i++){
		int t; char c;
		cin >> t >> c;
		turn.push(make_pair(t,c));
	}

	int head_r = 0; int head_c = 0;
	queue <pair<int, int> > q;//뱀의 좌표를 q에 담음
	int sec = 0;
	int i = 0;
	/*for(int i = 0; i<N; i++){
		for(int j = 0; j<N; j++){
			cout << arr[i][j];
		}
		cout <<"\n";
	}*/ // 입력이 제대로 되었는지 확인하는 코드 실행시에는 지워야함
	while(1){
		if((head_r>=N)||(head_c>=N)||(head_r<0)||(head_c<0)){//뱀이 벽이랑 충돌
			break;
		}
		else if(arr[head_r][head_c]== 1){//뱀이 사과를 만남
			q.push(make_pair(head_r, head_c));//현재 머리를 q에 담음
			arr[head_r][head_c] = 2;//좌표에 뱀의 위치 표시
		}
		else if(arr[head_r][head_c]== 0){
			q.push(make_pair(head_r, head_c));//현재 머리를 q에
			arr[head_r][head_c] = 2;//좌표에 뱀의 위치 표시
			if(q.front() != make_pair(head_r, head_c)){//0초인 경우에는 머리와 꼬리의 위치가 같아서 좌표에 기록이 안됨
				arr[q.front().first][q.front().second] = 0;//꼬리부분을 다시 빈칸으로 바꿈
				q.pop();//q에서 꼬리를 뺌
			}
		}
		else	break;//뱀이 자기 몸이랑 만남
		/*cout << sec<<"\n";
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				cout << arr[i][j] <<" ";
			}
			cout << "\n";
		}*///매 초마다 좌표를 볼려고 적은 코드
		if(sec ==turn.front().first){//시간이 바꿀 타이밍이 되면
			if(turn.front().second == 'D')	i++;//오른쪽이면 인덱스를 +1
			else	i--;//왼쪽이면 인덱스를 -1
			turn.pop();//바꿔줬으니까 pop
		}
		if(i==4)	i = 0;
		if(i==-1)	i = 3;
		head_r = head_r + dir_r[i];
		head_c = head_c + dir_c[i];
		
		sec++;
	}
	
	cout << sec ;
}
