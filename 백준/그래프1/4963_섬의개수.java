import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int w,h;
	static boolean[][] checked;
	static int[] dx = {-1,1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,-1,1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w =Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)
				break;
			
			map = new int[h][w];
			checked = new boolean[h][w];
			
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for(int i =0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(!checked[i][j] && map[i][j] == 1) {
						move(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		
		}
	}
	private static void move(int r, int c) {
		// TODO Auto-generated method stub
		checked[r][c] = true;
		
		for(int i = 0; i<8; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if(nx < 0 || nx >= h || ny <0|| ny>=w)
				continue;
			if(!checked[nx][ny] && map[nx][ny] == 1) {
				move(nx, ny);
			}
		}
		
	}

}
