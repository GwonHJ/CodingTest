#include <string>
#include <vector>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    int min = 21;
    int min_index = 0;
    string key = "";
    for(int i = 0; i<phone_book.size(); i++){
        if(phone_book[i].size()<min){
            key = phone_book[i];   
            min = phone_book[i].size();
            min_index = i;
        }
    }
    for(int i = 0; i<phone_book.size(); i++){
        int j=0;
        if(min_index == i)  continue;
        while(key[j] == phone_book[i][j]){
            j++;
            if(j==key.size())   return false;
        }
    }
    return answer;
}
