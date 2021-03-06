import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	
	    map = new int[N][M];
	    visited = new boolean[N][M];
	
	    // 치즈 : 1 외부 공기 : 2 내부 공기 : 0 녹은 치즈 : 3
	    
	    cnt = 0;
	    ans = 0;
	    
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            if (map[i][j] == 1)
	            	cnt++;
	        }
	    }
	
	    air_check(0, 0);
	
	    while (cnt != 0) {
	        visited = new boolean[N][M];
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (map[i][j] == 1 && !visited[i][j])
	                	dfs(i, j);
	            }
	        }
	
	        visited = new boolean[N][M];
	        air_check(0, 0);
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	            	if(map[i][j] == 3) {//녹은 치즈를 외부공기로 바꿈
	            		map[i][j] = 2;
	            	}
	            }
	        }
	
	        ans++;
	    }
	
	    System.out.println(ans);
	}
	
	
	static void air_check(int x, int y) {
	    visited[x][y] = true;
	    map[x][y] = 2;
	
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	
	        if (nx < 0 || ny < 0 || nx >= N || ny >= M)
	        	continue;
	        if (visited[nx][ny] || map[nx][ny] == 1)
	        	continue;
	
	        map[nx][ny] = 2;
	        air_check(nx, ny);
	    }
	}

	static boolean melt(int x, int y) {
		boolean ret = false;
		int air = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (map[nx][ny] == 2)
				air++;
		}
		if(air >= 2)
			ret = true;
		return ret;
	}
	
	static void dfs(int x, int y) {
	    visited[x][y] = true;
	
	    if (map[x][y] == 1 && melt(x, y)) {
	        cnt--;
	        map[x][y] = 3;
	    }
	
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	
	        if (nx < 0 || ny < 0 || nx >= N || ny >= M)
	        	continue;
	        if (visited[nx][ny] || map[nx][ny] == 0)
	        	continue;
	
	        dfs(nx, ny);
	    }
	}
	
}
