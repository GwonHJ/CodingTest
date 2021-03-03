import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
public class Main {
	public static int M, N;
    public static int[][] map;
    public static boolean[][] visited;
    public static String ans;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
	public static void main(String []args) throws NumberFormatException, IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
       	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	map = new int[M][N];
    	visited = new boolean[M][N];
    	
    	for(int i = 0; i<M; i++) {
    		String s = br.readLine();
    		for(int j = 0; j<N; j++) {
    			map[i][j] = s.charAt(j)-'0';
    		}
    	}
    	ans = "NO";
    	for(int i = 0; i<N; i++) {
    		if(visited[0][i] || map[0][i]==1)
    			continue;
    		visited[0][i] = true;
    		dfs(0,i);
    	}
    	
    	System.out.println(ans);
    }
	
	public static void dfs(int x, int y) {
		if(x == M-1) {
			ans = "YES";
			return;
		}
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=M || ny<0 || ny>=N )
				continue;
			if(map[nx][ny] == 1 || visited[nx][ny])
				continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
   
}
