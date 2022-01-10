import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[N+1][N+1];
		
		boolean[] visited = new boolean[N+1];
		
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;

		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i<=N; i++) {
				if(visited[i] || !map[now][i])
					continue;
				if(map[now][i]) {
					q.add(i);
					cnt++;
					visited[i] = true;
				}
					
			}
		}
		
		
		System.out.println(cnt);
		

	}

}
