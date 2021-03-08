import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [][] map;
	static boolean[][] visited;
	static int [] dx = {0, 1};
	static int [] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	map = new int[N][N];
    	visited = new boolean[N][N];
    	
    	for(int i = 0; i<N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dfs(0,0);
    	
    	System.out.println("Hing");
    }
    
    public static void dfs(int x, int y) {
    	
    	if(map[x][y] == -1) {
    		System.out.println("HaruHaru");
    		System.exit(0);
    	}
    	for(int i = 0; i<2; i++) {
    		int nx = x + dx[i]*map[x][y];
    		int ny = y + dy[i]*map[x][y];
    		
    		if(nx >= N || ny >= N) {
    			continue;
    		}
    		if(visited[nx][ny])
    			continue;
    		visited[nx][ny] = true;
    		dfs(nx, ny);   		
    	}
    }
 
}