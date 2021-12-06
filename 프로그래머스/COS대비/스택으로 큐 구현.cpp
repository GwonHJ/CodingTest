#include <string>
#include <vector>
#include <iostream>

using namespace std;

int func_a(vector<int> &stack);
void func_b(vector<int> &stack1, vector<int> &stack2);
bool func_c(vector<int> stack);

int func_a(vector<int> &stack) {
    int item = stack.back();
    stack.pop_back();
    return item;
}

void func_b(vector<int> &stack1, vector<int> &stack2) {
    while(!func_c(stack1)) {
        int item = func_a(stack1);
        stack2.push_back(item);
    }
}

bool func_c(vector<int> stack) {
    return (stack.size() == 0);
}

int solution(vector<int> stack1, vector<int> stack2) {
    if(func_c(stack2)){
        func_b(stack1, stack2);
    }
    int answer = func_a(stack2);
    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    vector<int> stack1_1 = {1,2};
    vector<int> stack2_1 = {3,4};
    int ret1 = solution(stack1_1, stack2_1);
    cout << "solution 함수의 반환 값은 " << ret1 << " 입니다." << endl;

    vector<int> stack1_2 = {1,2,3};
    vector<int> stack2_2 = {};
    int ret2 = solution(stack1_2, stack2_2);
    cout << "solution 함수의 반환 값은 " << ret2 << " 입니다." << endl;

    return 0;
}
