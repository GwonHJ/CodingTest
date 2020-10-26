//#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
using namespace std;
int main(){
    string a;
    int b;
    cin >> a >>b;
    int ans = 0;
    for(int i = 0; i<a.size();i++){
        if ('0'<=a[i] && a[i]<='9')    ans = ans*b + (a[i] - '0');
        else    ans = ans*b +(a[i] - 'A' + 10);
    }
    cout << ans << '\n';
    return 0;
}
