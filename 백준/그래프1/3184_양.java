import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
public class Main {

	static boolean visited[][];
	static char map[][];
	static int R, C;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int sheep;
	static int wolf;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i<R; i++) {
			String ss = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = ss.charAt(j);
			}
		}
		
		
		visited = new boolean[R][C];
		
//		울타리가 아닌 부분은 dfs를 돌린다
//		다 울타리인 곳이면 늑대의 수와 양의 수를 판별
//		늑대가 더 많으면 양은 0 아니면 늑대가 0
//		모든 맵을 다 돌았을때의 양의 수와 늑대의 수를 출력
		int s = 0;
		int w = 0;
		for(int i = 0; i <R; i++) {
			for(int j =0; j<C; j++) {
				if(visited[i][j] || map[i][j] == '#')
					continue;
				visited[i][j] = true;
				sheep = 0;
				wolf = 0;
				if(map[i][j] == 'o')
					sheep++;
				if(map[i][j] == 'v')
					wolf++;
				dfs(i,j);
				
				
				if(sheep > wolf)
					s += sheep;
				else
					w += wolf;
			}
		}
		
		System.out.println(s+" "+w);

	}
	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		
		for(int d = 0; d<4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			
			if(visited[nx][ny])
				continue;
			
			if(map[nx][ny] == '#')
				continue;
			
			visited[nx][ny] = true;
			if(map[nx][ny] == 'o')
				sheep++;
			if(map[nx][ny] == 'v')
				wolf++;
			
			dfs(nx, ny);
		}
		
	}

}
