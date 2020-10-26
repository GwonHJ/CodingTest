#include <string>
#include <vector>
#include <deque>

using namespace std;

deque <deque<int> > dq;
	
void turn(int target, int dir){
	if(dir == 1){
		dq[target].push_front(dq[target].back());
		dq[target].pop_back();
		return;
	}
	else{
		dq[target].push_back(dq[target].front());
		dq[target].pop_front();
		return;
	}
	return;
}

int main(){
	for(int i = 0; i<4; i++){
		deque <int> imsy_dq;
		for(int j = 0; j<8; j++){
			int a;	scanf("%1d",&a);
			imsy_dq.push_back(a);
		}
		dq.push_back(imsy_dq);
	}
	
	int N;	scanf("%d",&N);
	bool check[3];
	for(int i = 0; i<N; i++){
		int target;	scanf("%d",&target);
		target--;
		int dir;	scanf("%d",&dir);

		for(int j = 0; j<3; j++){
			if(dq[j][2]==dq[j+1][6]){
				check[j] = false;
			}
			else{
				check[j] = true;
			}
		}
		turn(target, dir);
		
		int temp_dir = dir;
		for(int cnt = target-1; cnt >=0; cnt--){//왼쪽
			if(!check[cnt])	break;
			
			if(temp_dir == 1)	temp_dir = -1;
			else	temp_dir = 1;
			
			turn(cnt, temp_dir);
		}
		temp_dir = dir;
		for(int cnt = target; cnt <3; cnt++){//오른쪽
			if(!check[cnt])	break;
			
			if(temp_dir == 1)	temp_dir = -1;
			else	temp_dir = 1;
			
			turn(cnt+1, temp_dir);
		}
	}
	
	int ans;
	ans = dq[0].front() + dq[1].front()*2 +dq[2].front()*4 + dq[3].front()*8;
	printf("%d",ans);
	return 0;
}
