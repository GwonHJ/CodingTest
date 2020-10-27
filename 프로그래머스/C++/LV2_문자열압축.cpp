#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(string s) {
    int n = s.size();
    int answer = n;
    for(int i = 1; i<=n/2; i++){       //압축할때 문자열의 n/2보다 크게하면 1이상이 나올수없어서 원래 문자열이 나옴
        string ans = "";    int cnt = 1;
        string cut = s.substr(0,i);
        for(int j = i ; j<=n; j += i){
            if(cut == s.substr(j,i)){
                cnt++;
            }
            else{
                if(cnt == 1){
                    ans += cut;
                    cut = s.substr(j,i);
                }
                else{
                    ans += to_string(cnt);
                    ans += cut;
                    cut = s.substr(j,i);
                    cnt = 1;
                }
            }
        }
        ans += s.substr(i*(n/i)-1,n-i*(n/i));
        
        answer = min(answer, (int)ans.size());
    }
    return answer;
}
