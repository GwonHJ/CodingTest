import java.util.*;
import java.io.*;

 
public class Main {
	static int N, M;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        comb(0,0,0);
        
        System.out.println(ans);
    }
	
	public static void comb(int start, int step, int sum) {
		if(step == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i = start; i<N; i++) {
			if(sum+arr[i]>M)
				continue;
			comb(i+1, step+1, sum+arr[i]);
		}
	}
}
