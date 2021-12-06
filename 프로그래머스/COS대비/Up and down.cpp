#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int K, vector<int> numbers, vector<string> up_down) {
    int left = 1;
    int right = K;
    for(int i = 0; i < numbers.size(); i++){
        int num = numbers[i];
        if(up_down[i] == "UP")
            left = (numbers[i]+1>left) ? numbers[i]+1 : left;
        else if(up_down[i] == "DOWN")
            right = (numbers[i]-1<right) ? numbers[i]-1 : right;
        else if(up_down[i] == "RIGHT")
            return 1;
    }
    return right-left+1;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    int K1 = 10;
    vector<int> numbers1 = {4, 9, 6};
    vector<string> up_down1 = {"UP", "DOWN", "UP"};
    int ret1 = solution(K1, numbers1, up_down1);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret1 << " 입니다." << endl;

    int K2 = 10;
    vector<int> numbers2 = {2, 1, 6};
    vector<string> up_down2 = {"UP", "UP", "DOWN"};
    int ret2 = solution(K2, numbers2, up_down2);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret2 << " 입니다." << endl;

    int K3 = 100;
    vector<int> numbers3 = {97, 98};
    vector<string> up_down3 = {"UP", "RIGHT"};
    int ret3 = solution(K3, numbers3, up_down3);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret3 << " 입니다." << endl;
}
