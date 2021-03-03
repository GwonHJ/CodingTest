import java.util.*;
import java.io.*;

public class Main {

	static char[][] map;
	static boolean[] checked;
	static int R,C,ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		checked = new boolean[26];
		
		for(int i = 0; i<R; i++) {
			String temp = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		checked[map[0][0]-'A'] = true;
		visit(0,0,1);
		
		System.out.println(ans);
		
	}
	
	public static void visit(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >=R || ny <0 || ny >= C) 
				continue;
			
			if(!checked[map[nx][ny]-'A']) {
				checked[map[nx][ny]-'A'] = true;
				visit(nx, ny, cnt+1);
				checked[map[nx][ny]-'A'] = false;
			}
		}
	}

}
