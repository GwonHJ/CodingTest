import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	long[] dp = new long[1000001];
    	
    	dp[0] = 0;
    	dp[1] = 0;
    	dp[2] = 1;
    	dp[3] = 2;
    	dp[4] = 9;
    	
    	for(int i = 5; i<=N; i++) {
    		dp[i] = (i-1)*(dp[i-2]%1000000000+dp[i-1]%1000000000)%1000000000;
    	}
    	
    	System.out.println(dp[N]);
    }
   
    
}
