// 다음과 같이 include를 사용할 수 있습니다.
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int K, vector<string> words) {
    // 여기에 코드를 작성해주세요.
    int answer = 0;
    int length = 0;
    for(int i = 0; i< words.size(); i++){
        if(length == 0){
            answer++;
            length += words[i].size()+1;
        }else if(length + words[i].size() > K){
            answer++;
            length = words[i].size()+1;
        }else{
            length += words[i].size()+1;
        }
    }
    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    int K = 10;
    vector<string> words = {"nice", "happy", "hello", "world", "hi"};
    int ret = solution(K, words);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret << " 입니다.";
}
