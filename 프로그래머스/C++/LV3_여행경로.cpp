#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool check[10001];


vector <string> answer;

bool dfs(string start, int cnt, int end_cnt, vector<vector<string>> tickets, vector<string> v) {

	if (cnt == end_cnt) {
		for (int i = 0; i < v.size(); i++) {
			answer.push_back(v[i]);
		}
		return true;
	}

	for (int i = 0; i < tickets.size(); i++) {
		if (start == tickets[i][0] && !check[i]) {
			check[i] = true;
			v.push_back(tickets[i][1]);
			bool result = dfs(tickets[i][1], cnt + 1, end_cnt, tickets, v);
			if (result)
				return true;
			check[i] = false;
			v.pop_back();
		}
	}

	return false;

}


vector<string> solution(vector<vector<string>> tickets) {

	sort(tickets.begin(), tickets.end()); //알파벳 순서대로 정렬
	string start = "ICN";

	answer.push_back(start);
	int cnt = 0;
	int end_cnt = tickets.size();

	vector <string> v;
	dfs(start, cnt, end_cnt, tickets, v);

	return answer;
}
