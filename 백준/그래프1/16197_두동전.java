import java.util.*;
import java.io.*;

public class Main {

	static char[][] map;
	static int R,C, ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		int cnt = 0;
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 =0;
		
		for(int i = 0; i<R; i++) {
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(cnt<2 && map[i][j]=='o') {
					if(cnt == 0) {
						x1 = i;	y1 =j;
						cnt++;
					}else {
						x2 = i; y2 = j;
						cnt++;
					}
				}
			}
		}
		ans = 11;
		dfs(x1, x2, y1, y2, 1);
		if(ans == 11)
			System.out.println(-1);
		else
			System.out.println(ans);
	
	}
	
	public static void dfs(int x1, int x2, int y1, int y2, int cnt) {
		
		if(cnt>10) {
			return;
		}
		for(int i = 0; i<4; i++) {
			int nx1 = x1 + dx[i];
			int ny1 = y1 + dy[i];
			int nx2 = x2 + dx[i];
			int ny2 = y2 + dy[i];
			if(nx1<0 || ny1<0 || nx1>=R || ny1 >= C) {
				if(nx2<0||ny2<0||nx2>=R||ny2>=C)
					continue;
				else {
					ans = Math.min(ans, cnt);
					return;
				}
			}
			else if(nx2<0||ny2<0||nx2>=R||ny2>=C) {
				if(nx1<0 || ny1<0 || nx1>=R || ny1 >= C)
					continue;
				else {
					ans = Math.min(ans, cnt);
					return;
				}
			}
			if(map[nx1][ny1]== '#') {
				nx1 = x1;
				ny1 = y1;
			}
			if(map[nx2][ny2]== '#') {
				nx2 = x2;
				ny2 = y2;
			}
			dfs(nx1, nx2, ny1, ny2, cnt+1);
			
		}
	}

}
