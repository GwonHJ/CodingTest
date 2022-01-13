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

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					cnt++;
			}
		}
		int idx = 0;
		
		while(true) {
			idx++;
			int now = bfs();
			
			if(now == 0)
				break;
			cnt = now;
		}
		

		System.out.println(idx);
		System.out.println(cnt);
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(new Point(0,0));
		while(!q.isEmpty()) {
			Point now = q.poll();
					
			for(int d=0; d<4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];				
				if(nx < 0 || ny<0 || nx>=N || ny >= M)
					continue;
				if(visited[nx][ny])
					continue;
						
				if(map[nx][ny] == 0)
					q.add(new Point(nx,ny));
				map[nx][ny] = 0;
				visited[nx][ny] = true;
			}
					
		}

		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]==1)
					cnt++;
			}
		}
		
		return cnt;
	}

}

