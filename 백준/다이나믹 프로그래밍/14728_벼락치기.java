import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] sumT = new int[N+1];
		int[] sumS = new int[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			sumT[i] = Integer.parseInt(st.nextToken());
			sumS[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][T+1];
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=T; j++) {
				if(j<sumT[i]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-sumT[i]]+sumS[i]);
				}
			}
		}
		
		System.out.println(dp[N][T]);

	}

}
