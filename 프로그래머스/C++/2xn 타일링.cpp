#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int n0 = 0;
    int n1 = 1;
    for(int i = 1; i<=n; i++ ){
            answer = (n0 + n1)%1000000007;
            n0 = n1;
            n1 = answer;
    }
    return answer;
}
