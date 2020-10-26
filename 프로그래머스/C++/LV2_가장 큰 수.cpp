#include <string>
#include <vector>
#include <algorithm>
#include <string.h>
using namespace std;

bool compare(string a, string b){
    int n = min(a.size(),b.size());
    int m = max(a.size(),b.size());
    if(n == 0 )  return false;
    if(a.size()<=b.size()){
        for(int i=0; i<m; i++){
            if(a[i%n]>b[i]) return true;
            else if(a[i%n]<b[i]) return false;
        }
        if(a[n-1] > b[m-1]) return true;
    }
    else{
        for(int i=0; i<m; i++){
            if(a[i]>b[i%n]) return true;
            else if(a[i]<b[i%n]) return false;
        }
        if(a[m-1] > b[n-1]) return true;
    }
    return false;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> number;

    for(int i=0; i<numbers.size(); i++) number.push_back(to_string(numbers[i]));
    sort(number.begin(),number.end(),compare);
    
    if(number[0]=="0")   return "0";
    for(int i=0; i<number.size(); i++)  answer += number[i];
    return answer;
}
