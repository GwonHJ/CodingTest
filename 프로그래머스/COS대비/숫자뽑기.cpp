// 다음과 같이 include를 사용할 수 있습니다.
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> arr, int K) {
    // 여기에 코드를 작성해주세요.
    int answer = 100001;
    
    sort(arr.begin(), arr.end());
    
    for(int i =0; i<arr.size()-K+1; i++){
        answer = min(answer, arr[i+K-1]-arr[i]);
    }
    
    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    vector<int> arr = {9, 11, 9, 6, 4, 19};
    int K = 4;
    int ret = solution(arr, K);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret << " 입니다." << endl;
}
