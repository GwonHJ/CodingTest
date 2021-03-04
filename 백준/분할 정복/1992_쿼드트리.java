import java.io.*;
import java.util.*;
public class Main {

	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j =0; j<N; j++) {
				map[i][j] = (int)tmp.charAt(j)-'0';
			}
		}
		
		sb = new StringBuilder();
		quad(0,0,N);
		
		System.out.println(sb);
	}
	
	public static int check(int r, int c, int N) {
		int ret = map[r][c];
		for(int i = r; i<r+N; i++) {
			for(int j = c; j<c+N; j++) {
				if(map[i][j] != ret) {
					return -1;
				}
			}
		}
		return ret;
	}
	
	public static void quad(int r, int c, int N) {
		int ans = check(r, c, N);
		if(ans != -1) {
			sb.append(ans);
		}else {
			sb.append("(");
			int tmp = N/2;
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<2; j++) {
					quad(r+tmp*i, c+tmp*j, tmp);
				}
			}
			sb.append(")");
		}
	}

}
