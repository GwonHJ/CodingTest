import java.util.*;
import java.io.*;
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
public class Main {

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int M = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				M = Integer.max(M, map[i][j]);
			}
		}
		
		int answer = 0;
		//강수량이 0~M까지 다 돌려본다
//		현재 좌표가 r보다 크면 dfs or bfs를 돌린다
//		다 돌리면 안전영역+1
//		모든 좌표를 다 돌리면 안전영역의 개수를 구할 수 있음
//		안전 영역 개수를 구하면 다시 visited를 false로
//		모든 강수량을 돌려서 최대를 구함
		for(int r = 0; r<= M ; r++) {
			
			boolean visited[][] = new boolean[N][N];
			int cnt = 0;
			
			for(int i = 0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(visited[i][j] || map[i][j] <= r)
						continue;
					
					Queue<Point> q = new LinkedList<>();
					Point p = new Point(i, j);
					visited[i][j] = true;
					q.add(p);
					
					while(!q.isEmpty()) {
						Point now = q.poll();
						for(int d = 0; d<4; d++) {
							int nx = now.x + dx[d];
							int ny = now.y + dy[d];
							
							if(nx <0 || ny< 0 || nx >=N || ny >=N)
								continue;
							
							if(visited[nx][ny] || map[nx][ny] <= r)
								continue;
							
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
							
						}
					}
					
					cnt++;
					
				}
			}
			
			answer = Math.max(cnt, answer);
		}
		
		System.out.println(answer);
	}

}
