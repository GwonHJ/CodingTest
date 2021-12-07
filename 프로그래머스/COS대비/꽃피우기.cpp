// 다음과 같이 include를 사용할 수 있습니다.
#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<vector<int>> garden) {
    // 여기에 코드를 작성해주세요.
    int answer = 0;
    
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    
    int n = garden.size();
    int cnt = 0;
    
    bool visited[n][n];
    queue<int> flowers;
    
    //초기값 확인
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if(garden[i][j] == 1){
                flowers.push(i*n+j);
                cnt++;
            }
        }
    }
    
    while(cnt < n*n){
        answer++;
        int size = flowers.size();
        for(int i = 0; i<size; i++){
            int now = flowers.front();
            flowers.pop();
            for(int d = 0; d<4; d++){
                int nx = now/n + dx[d];
                int ny = now%n + dy[d];

                if(nx < 0 || ny <0 || nx >= n || ny >= n)
                    continue;
                if(garden[nx][ny] == 0){
                    cnt++;
                    flowers.push(nx*n + ny);
                    garden[nx][ny] = 1;
                }
            }
            
        }
        
    }
    
    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    vector<vector<int>> garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int ret1 = solution(garden1);
    
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret1 << " 입니다." << endl;
    
    vector<vector<int>> garden2 = {{1, 1}, {1, 1}};
    int ret2 = solution(garden2);
    
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret2 << " 입니다." << endl;
}
