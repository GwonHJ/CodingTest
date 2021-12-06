#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

const int INC = 0;
const int DEC = 1;

vector<int> func_a(vector<int> arr) {
    int length = arr.size();
    vector<int> ret(length,0);
    ret[0] = 1;
    for(int i = 1; i < length; i++) {
        if(arr[i] != arr[i-1])
            ret[i] = ret[i-1] + 1;
        else
            ret[i] = 2;
    }
    return ret;
}

vector<int> func_b(vector<int> arr) {
    int length = arr.size();
    vector<int> ret(length, 0);
    ret[0] = -1;
    for(int i = 1; i < length; i++) {
        if(arr[i] > arr[i-1])
            ret[i] = INC;
        else if(arr[i] < arr[i-1])
            ret[i] = DEC;
    }
    return ret;
}

int func_c(vector<int> arr) {
    int length = arr.size();
    int ret = 0;
    for(int i = 0; i < length; i++)
        if(ret < arr[i])
            ret = arr[i];
    if(ret == 2)
        return 0;
    return ret;
}

int solution(vector<int> S) {
    vector<int> check = func_b(S);
    vector<int> dp = func_a(check);
    int answer = func_c(dp);
    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    vector<int> S1 = {2, 5, 7, 3, 4, 6, 1, 8, 9};
    int ret1 = solution(S1);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    printf("solution 함수의 반환 값은 %d 입니다.\n", ret1);

    vector<int> S2 = {4, 3, 2, 1, 10, 6, 9, 7, 8};
    int ret2 = solution(S2);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    printf("solution 함수의 반환 값은 %d 입니다.\n", ret2);

    vector<int> S3 = {1, 2, 3, 4, 5};
    int ret3 = solution(S3);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    printf("solution 함수의 반환 값은 %d 입니다.\n", ret3);
}
