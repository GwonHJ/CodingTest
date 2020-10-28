# CodingTest


백준
https://www.acmicpc.net/

프로그래머스
https://programmers.co.kr/

삼성 SW Expert Academy
https://swexpertacademy.com/main/main.do

--------------------------------------------------------------
# 자료구조 & 알고리즘 간단 정리


## 스택


![stack](https://user-images.githubusercontent.com/45057466/97438280-ee94ff00-1967-11eb-9755-9dbfab889975.png)

  한 쪽 끝에서만 자료를 넣고 뺄 수 있는 선형 구조(LIFO - Last In First Out)
  
  push : 자료를 밀어 넣는다.
  
  pop : 가장 최근에 넣은(가장 위에 있는) 자료를 꺼낸다.
  
    
## 큐



![queue](https://user-images.githubusercontent.com/45057466/97438299-f3f24980-1967-11eb-8ee6-a65bcff7a813.png)

  뒤에서 자료를 넣고 앞에서만 뺼 수 있는 선형 구조(FIFO - First In First Out)
  
  push : 자료를 밀어 넣는다.
  
  pop : 가장 오래된(가장 앞에 있는) 자료를 꺼낸다.

  ***자바와 c++에서 명령어가 서로 다름!!***
  
  자바에서 큐는 스택과 달리 별도의 인터페이스 형태로 제공
  
  링크드리스트를 이용해서 큐 메모리 구조를 구현이 가능하다
  
  

## Heap

  우선 순위 큐를 위해서 만들어진 자료구조
  
  우선순위 큐 : 데이터들이 우선순위를 가지고 있고 우선순위가 높은 데이터가 먼저 나간다.
  
  

## sort


## 그래프 정의
  
  '정점(node)'과 '간선(edge)'으로 이루어진 자료구조
  
  간선의 방향 유무에 따라서 단방향 그래프와 양방향 그래프(무방향 그래프)로 나뉜다.
  
  완전탐색 문제 풀때 많이 씀
  
  그래프 탐색 기법 : DFS, BFS, 다익스트라, 플로이드와샬
  
  그래프 탐색 유형 : 미로, 정점 이동
  
## 트리

  ![tree](https://user-images.githubusercontent.com/45057466/97464210-f5ca0600-1983-11eb-959b-6861c5d116aa.png)
  
  
  그래프의 한 종류, 계층 구조를 나타내기 좋음.
  
  1. 1개의 루트 노드를 가짐
  
  2. 0개 이상의 서로 다른 자식 노드를 가짐
  
  3. 두 개의 노드를 연결하는 간선은 하나만 존재
  
  
## DFS/BFS

  ### DFS(Depth First Search : 깊이 우선 탐색)
  
  현재 정점에서 연결된 정점을 하나 골라서 파고들수 있는 최대한 깊게 파고 들어가며 탐색
  
  Stack을 이용 or 재귀를 이용
  
  재귀를 이용하면 매우 간단하게 짤 수 있음.

  <재귀를 이용한 DFS 함수>
  ```cpp
  vector<vector<int> > graph;
  bool visited[N];
  void dfs(int here){
        visited[here] = true;
        for( int i = 0; i<graph[here].size(); i++){
              int there = graph[here][i];
              int(!visited[there])
                    dfs(there);
        }
  }
                                        
  int main(){
    for(int i = 0; i<graph.size(); i++){
      if(!visited[i])
        dfs(i);
    }
  }
```
  ### BFS(Breadth First Search : 너비 우선 탐색)
  
  현재 정점과 연결된 정점들에 대해 우선적으로 넓게 탐색
  
  Queue를 이용
  
  
  <Queue를 이용한 BFS 함수>
```cpp
	
vector<vector<int> > graph;
//vector<int> order; 정점의 방문순서가 필요할때
bool visited[N];
  void bfs(int start){
	queue<int> q;
	visited[start] = true;
	q.push(start);
	while(!q.empty()){
		int here = q.front();
		q.pop();
		//order.push_back(here);
		for(int i = 0; i<graph[here].size(); i++){
			int there = graph[here][i];
			visited[there] = true;
		}
	}
  }
                                        
  int main(){
    for(int i = 0; i<graph.size(); i++){
      if(!visited[i])
        bfs(i);
    }
  }
```
## 그리디 알고리즘

  욕심쟁이 알고리즘
  
  지금 가장 최적인 답을 선택해서 결과를 내는 알고리즘
  
  ***주의: 선택하는 순간에 최적이기 때문에 최종적으로 최적의 알고리즘이 아닐 수 있다.***
  
  그리디 사용 예시 : 다익스트라 알고리즘, 프림 알고리즘

## 다이나믹 프로그래밍

  하나의 문제는 단 한 번만 계산하도록 하는 알고리즘
  
  ### 다이나믹 프로그래밍의 조건
  
  1. 작은 문제가 반복이 일어나는 경우
  2. 같은 문제는 구할 때마다 정답이 같다.
  
  ### 구현방법

  1. Bottom-up : 작은 문제부터 차근차근 구해나가아가는 방법
  
  2. Top-down : 재귀 함수를 이용해서 구현, 큰 문제를 풀 때 작은 문제를 풀지 않았다면 그때 작은 문제 푸는 방법
  
## 브루트포스

## 시뮬레이션



-----------------------------------------------------------------

# C++ 래퍼런스

**알고리즘 문제 풀 때 잘 쓰는거 위주로

-permutation

-sort

-pair

-vector

-구조체

-string 함수



![판다](https://user-images.githubusercontent.com/45057466/97436199-f1422500-1964-11eb-9876-08a921d1df87.png)
