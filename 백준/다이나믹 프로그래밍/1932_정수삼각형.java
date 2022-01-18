import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] input = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<=i; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][n];
		
		if(n == 1) {
			System.out.println(input[0][0]);
		}else {
			
		dp[0][0] = input[0][0];
		dp[1][0] = dp[0][0]+input[1][0];
		dp[1][1] = dp[0][0]+input[1][1];
		for(int i = 2; i<n; i++) {
			dp[i][0] = dp[i-1][0] + input[i][0];
			dp[i][i] = dp[i-1][i-1] + input[i][i];
			for(int j = 1; j<i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + input[i][j];
			}
			
		}
		
		int ans = 0;
		
		for(int i = 0; i<n; i++) {
			ans = Math.max( dp[n-1][i], ans);
		}
		
		System.out.println(ans);
		}
	}

}
