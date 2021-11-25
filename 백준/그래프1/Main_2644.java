import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n+1][n+1];
		boolean visited[] = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(a);
		visited[a] = true;
		
		int ans = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i<size; i++) {
				
				int now = queue.poll();
				if(now == b) {
					System.out.println(ans);
					return;
				}
				
				for(int j = 1; j<=n; j++) {
					if(visited[j])
						continue;
					if(graph[now][j] == 1) {
						visited[j] = true;
						queue.add(j);
					}
				}
			
		
			}
			ans++;
		}
		
		System.out.println(-1);
		
	}

}
