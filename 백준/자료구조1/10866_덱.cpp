#include<iostream>
#include<string>
#include<algorithm>
#include<deque>
using namespace std;

int main() {
	deque <int> deque;
	int N;	scanf("%d",&N);
	string s;
	for(int i=0; i<N;i++){
		int num;
		cin >> s;
		if(s=="push_front"){
			scanf("%d",&num);
			deque.push_front(num);
		}
		else if(s=="push_back"){
			scanf("%d",&num);
			deque.push_back(num);
		}
		else if(s=="pop_front"){
			if(deque.size()==0){
				cout << -1 << "\n";
				continue;
			}
			cout << deque.front() << "\n";
			deque.pop_front();
		}
		else if(s=="pop_back"){
			if(deque.size()==0){
				cout << -1 << "\n";
				continue;
			}			
			cout << deque.back() << "\n";
			deque.pop_back();
		}
		else if(s=="front"){
			if(deque.size()==0){
				cout << -1 << "\n";
				continue;
			}
			cout << deque.front() << "\n";
		}
		else if(s=="back"){
			if(deque.size()==0){
				cout << -1 << "\n";
				continue;
			}
			cout << deque.back()<<"\n";
		}
		else if(s=="empty"){
			if(deque.size()==0){
				cout << 1 << "\n";
			}
			else{
				cout << 0 << "\n";
			}
		}
		else if(s=="size"){
			cout << deque.size() << "\n";
		}
	}
	return 0;
}
