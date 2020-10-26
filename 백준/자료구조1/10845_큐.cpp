#include<iostream>
#include<string>
using namespace std;

int main() {
	int N;
	cin >> N; 
	int queue[10000] = { 0 };
	int back = 0;	int front = 0;
	for (int i = 0; i < N; i++) {
		string a;
		cin >> a;
		int size = back - front;
		if (a == "front") { 
			if (size == 0) cout << -1 << '\n';
			else    cout << queue[front] << '\n';
		}
		else if (a == "back"){
			if (size == 0) cout << -1 << '\n';
			else    cout << queue[back-1] << '\n';
			
		}
		else if (a == "size")	cout << size << '\n';
		else if (a == "empty") {
			if (size == 0)    cout << 1 << '\n';
			else    cout << 0 << '\n';
		}
		else if (a == "pop") {
			if (size > 0) {
				cout << queue[front] << '\n';
				front++;
			}
			else cout << -1 << '\n';
		}
		else {
			cin >> queue[back];
			back++;
		}

		}
	return 0;
}
