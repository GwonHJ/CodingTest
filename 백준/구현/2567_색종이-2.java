import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[101][101];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j = a; j< a+10; j++) {
				for(int k = b; k< b+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int ans = 0;
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				if(map[i][j] == 1)
					continue;
				for(int k = 0; k<4; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if(x<0||y<0||x>100||y>100)
						continue;
					if(map[x][y]==0)
						continue;
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}
