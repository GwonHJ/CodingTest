#include<iostream>
#include<string>
using namespace std;

int main() {
	int N;
	cin >> N; 
	int stack[10000] = { 0 };
	int size = 0;
	for (int i = 0; i < N; i++) {
		string a;
		cin >> a;
		if (a == "top") { 
			if (size == 0) cout << -1 << '\n';
			else    cout << stack[size-1] << '\n';
		}
		else if (a == "size")	cout << size << '\n';
		else if (a == "empty") {
			if (size == 0)    cout << 1 << '\n';
			else    cout << 0 << '\n';
		}
		else if (a == "pop") {
			if (size > 0) {
				cout << stack[size-1] << '\n';
				size--;
			}
			else cout << -1 << '\n';
		}
		else {
			cin >> stack[size];
			size++;
		}

		}
	return 0;
}
