# CodingTest

## 문제 사이트

백준
https://www.acmicpc.net/

프로그래머스
https://programmers.co.kr/

삼성 SW Expert Academy
https://swexpertacademy.com/main/main.do

--------------------------------------------------------------
# 자료구조 & 알고리즘 간단 정리

코딩테스트를 위한 간단 정리!!

면접을 위한 개념정리는 [Job_interview README.md](https://github.com/GwonHJ/Job_Interview/blob/main/README.md)에 있습니다.

## 스택


![stack](https://user-images.githubusercontent.com/45057466/97438280-ee94ff00-1967-11eb-9755-9dbfab889975.png)

  한 쪽 끝에서만 자료를 넣고 뺄 수 있는 선형 구조(LIFO - Last In First Out)\
  
  **C++ Stack 기본 함수**
  
  - push(element): top에 원소를 추가
  - pop(): top에 있는 원소를 삭제
  - top(): top(스택의 처음이 아닌 가장 끝)에 있는 원소를 반환
  - empty(): 스택이 비어있으면 true 아니면 false를 반환
  - size(): 스택 사이즈를 반환

  
    
## 큐

![queue](https://user-images.githubusercontent.com/45057466/97438299-f3f24980-1967-11eb-8ee6-a65bcff7a813.png)

  뒤에서 자료를 넣고 앞에서만 뺼 수 있는 선형 구조(FIFO - First In First Out)

  **자바와 c++에서 명령어가 서로 다름!!**
  
  자바에서 큐는 스택과 달리 별도의 인터페이스 형태로 제공
  
  링크드리스트를 이용해서 큐 메모리 구조를 구현이 가능하다
  
  **C++ Queue 기본함수**

  - push(element): 큐에 원소를 추가(뒤에)
  - pop(): 큐에 있는 원소를 삭제(앞에)
  - front(): 큐 제일 앞에 있는 원소를 반환
  - back(): 큐 제일 뒤에 있는 원소를 반환
  - empty(): 큐가 비어있으면 true 아니면 false를 반환
  - size(): 큐 사이즈를 반환


## Heap

  우선 순위 큐를 위해서 만들어진 자료구조
  
  우선순위 큐 : 데이터들이 우선순위를 가지고 있고 우선순위가 높은 데이터가 먼저 나간다.
  
  **C++ 우선순위 큐 기본함수**
   - priority_queue<T, Container, Compare>: 원하는 자료형 및 클래스 T를 통해 생성. 여기서 Container는 vector와 같은 컨테이너이며 Compare는 비교함수 클래스이다.
   - push(element): 우선순위 큐에 원소 추가
   - pop(): 우선순위 큐에서 top의 원소를 삭제
   - top(): top에 있는 원소를 반환
   - empty(): 비어있으면 true 아니면 false를 반환
   - size(): 우선순위 큐에 포함되어 있는 원소들의 수를 반환

## Sort

  sort()함수는 algorithm헤더에 포함.
  
  기본적으로 오름차순.
  
   **C++ sort기본함수**
   
   - sort(arr, arr+n);					//배열
   - sort(v.begin(), v.end());				//벡터
   - sort(v.begin(), v.end(), compare);			//사용자 정의 함수 사용

   sort내림차순하는 방법
   
   1. sort(v.begin(), v.end(), greater<자료형>());
   2. bool cmp(자료형 a, 자료형 b){
   	 return a > b;
      }
      sort(arr, arr+n, cmp);
      
   묶어서 정렬하는 방법 : 구조체로 만들어서 cmp함수를 만든다
   - 2개일때 : pair를 사용하면 구조체를 안만들어도 정렬 **하지만 first값을 기준으로 정렬하는 것을 명심**
   - 3개 이상일때 : 구조체를 만들어서 cmp함수를 만든다 **cmp함수는 하나하나 다 적어야함!! 하나도 빠지지말것!!**

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
  
  
  **트리는 싸이클이 존재하지 않음!!!**
  
  
## DFS/BFS

  코딩테스트에서 난이도 높은 문제로 그래프 탐색이 많이 나옴! DFS함수와 BFS함수는 바로 짤 수 있을 만큼 익힐것!
 
  ### DFS(Depth First Search : 깊이 우선 탐색)
  
  현재 정점에서 연결된 정점을 하나 골라서 파고들수 있는 최대한 깊게 파고 들어가며 탐색
  
  Stack을 이용 or 재귀를 이용
  
  재귀를 이용하면 매우 간단하게 짤 수 있음.

  <재귀를 이용한 DFS 함수>
  ```cpp
  vector<vector<int> > graph;
  bool visited[N];//노드에 방문했는지 여부 확인
  void dfs(int here){
        visited[here] = true; //노드에 방문 표시
        for( int i = 0; i<graph[here].size(); i++){
              int there = graph[here][i]; // 현재 노드와 연결된 노드를 there로 가져온다
              int(!visited[there]) // 만약 연결된 노드에 방문한 적이 없다
                    dfs(there);//there노드 방문
        }
  }
                                        
  int main(){
    for(int i = 0; i<graph.size(); i++){//만약 모든 노드가 다 연결 되어있다면 바로 dfs(start)하면 되지만 아닐 모든 노드가 연결되어있지않으면 확인 필요
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
	visited[start] = true; // 방문 표시
	q.push(start);//시작 노드를 큐에 푸쉬
	while(!q.empty()){
		int here = q.front();//방문할 노드를 here로 받아옴
		q.pop();
		//order.push_back(here);// 정점 방문 순서
		for(int i = 0; i<graph[here].size(); i++){
			int there = graph[here][i];// here노드와 연결된 노드들을 queue에 넣는다
			visited[there] = true;//노드를 
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
  







![판다](https://user-images.githubusercontent.com/45057466/97436199-f1422500-1964-11eb-9876-08a921d1df87.png)
