import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int res;
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};
    static class S{
        int x, y;
        int size = 2;
        int cnt = 0;
    }
    static S s;
    static class F implements Comparable<F>{
        int x, y;
        int dist;
        public F(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public F(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(F o) {
        	//거리, y, x기준 비교
            if(dist == o.dist) {
                if(y == o.y) {
                    return x - o.x;
                }else {
                    return y - o.y;
                }
            }else {
                return Integer.compare(dist, o.dist);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        s = new S();
        res = 0; //최대값, 최소값, 
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
//                상어찾기
                if(map[i][j] == 9) {
                    s.x = j;
                    s.y = i;
//                    상어자리 빈자리 만들기
                    map[i][j] = 0; // 0
                }
            }
        }

//        솔루션
        while(bfs()) {
        }
        System.out.println(res);

    }
    private static boolean bfs() {
        Queue<F> q = new LinkedList<>();
//        방문체크배열
        int[][] v = new int[N][N]; // -1
        for(int i = 0; i < N; i++) {
            Arrays.fill(v[i], -1);
        }
//        첫번째 위치 삽입, 방문체크
        q.offer(new F(s.x, s.y));
        v[s.y][s.x] = 0;
        ArrayList<F> list = new ArrayList<>();
        F cur;
        int nx, ny;
        while(!q.isEmpty()) {
            cur = q.poll();
//            4밤위 탐색
            for(int d = 0; d < 4; d++) {
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
//                범위체크
                if(nx < 0 || nx >= N || ny <0 || ny >= N) {
                    continue;
                }
//                갈수있나없나
                if(v[ny][nx]!=-1) {
                    continue;
                }
                if(s.size < map[ny][nx]) {
                    continue;
                }
//              상어와 물고기의 거리 체크를 위해서 int로 방문체크
                v[ny][nx] = v[cur.y][cur.x] + 1;
                q.offer(new F(nx, ny));
//                잡을수있나없나
                if(map[ny][nx] != 0 && s.size > map[ny][nx]) {
//                	잡을 수 있는 물고기를 list에 넣는다
                    list.add(new F(nx, ny,v[ny][nx]));
                }

            }

        }
//		잡을 수 있는 물고기가 없으면 while문 종료
        if(list.size() == 0) {
            return false;
        }
//      물고기를 거리, y, x순으로 정렬하여 지금 잡을 물고기 고르기
        Collections.sort(list);
        F temp = list.get(0);
//      res에 잡을 물고기와 현재 위치의 거리를 더해준다.
        res += temp.dist;
//      상어의 위치를 지금 잡은 물고기로 변경
        s.x = temp.x;
        s.y = temp.y;
        map[temp.y][temp.x] = 0;
        s.cnt++;
//      상어는 자신의 크기와 같은 수의 물고기를 먹으면 크기가 증가
        if(s.size == s.cnt) {
            s.size++;
            s.cnt = 0;
        }

        return true;
    }

}
