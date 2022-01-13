#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
using namespace std;

bool comp(pair<string, int> a, pair<string, int> b){
    return a.second > b.second;
}

bool compSong(pair<int, int> a, pair<int, int>b){
    if(a.first > b.first)
        return true;
    
    if(a.first == b.first){
        if(a.second < b.second)
            return true;
    }
    return false;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string, int> genre;
    map<string, vector<pair<int, int>>> song;
    
    
    for(int i =0; i<genres.size(); i++){
        genre[genres[i]] += plays[i];
        song[genres[i]].push_back(make_pair(plays[i],i));
    }
    
    int idx = 0;
    
    vector<pair<string, int>> genreSort ={genre.begin(), genre.end()};
    sort(genreSort.begin(), genreSort.end(), comp);
    for(auto g : genreSort){
        vector<pair<int, int>> playSort = {song[g.first].begin(), song[g.first].end()};
        sort(playSort.begin(), playSort.end(), compSong);
        answer.push_back(playSort[0].second);
        if(playSort.size() > 1)
            answer.push_back(playSort[1].second);
        
    }
    return answer;
}
